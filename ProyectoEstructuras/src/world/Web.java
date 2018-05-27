package world;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import auxiliarDataStructures.CommutativePair;

public class Web {

	private IGraph<Domain, String> net;

	public Web() {
		net = new GraphList<Domain, String>(true);
		Domain d1 = new Domain("https://www.google.com.co", "google.com.co");
		Domain d2 = new Domain("https://adwords.google.com", "adwords.google.com");
		net.addEdge("https://www.google.com.co/intl/en_co/ads", d1, d2);
	}

	/**
	 * @param startingPoint
	 * @param depth
	 * @throws IOException
	 */
	public int expandGraph(Domain domain, String link, int depth, HashSet<String> hs, boolean firstCall)
			throws IOException {
		int b = 0;
		if (firstCall)
			net = new GraphList<Domain, String>(true);
		if (depth > 0 && !hs.contains(link)) {
			hs.add(link);
			// System.out.println(link);
			depth--;
			Document doc = null;
			try {
				doc = Jsoup.connect(link).get();
			} catch (MalformedURLException e) {
				throw new MalformedURLException();
			} catch (HttpStatusException e) {
				throw new HttpStatusException("Ha ocurrido un error de tipo: " + e.getStatusCode()
						+ " al intentar cargar la p�gina " + e.getUrl() + " del grafo", e.getStatusCode(), e.getUrl());
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
			Elements elements = doc.select("a");
			// System.out.println(elements.size());
			Iterator<Element> itLinks = elements.iterator();
			while (itLinks.hasNext()) {
				Element l = itLinks.next();
				// System.out.println(l);
				String absHref = l.attr("abs:href");
				// System.out.println(absHref);
				if (!absHref.isEmpty() && absHref != null) {
					// System.out.println(absHref);
					String[] URL = absHref.split("//");
					String[] part = null;
					try {
						part = URL[1].split("/");
					} catch (Exception e) {
						continue;
					}
					String name = part[0];
					if (name.substring(0, 4).equals("www.")) {
						name = name.substring(4);
					}
					if (!domain.getName().equals(name)) {
						Domain newdomain = new Domain(URL[0] + "//" + part[0], name);
						boolean a = net.addEdge(link, domain, newdomain);
						if (a) {
							b += 1 + expandGraph(newdomain, newdomain.getURL(), depth, hs, false);
						}
					} else {
						b += expandGraph(domain, absHref, depth, hs, false);
					}
				}
			}
		}
		return b;
	}

	/**
	 * 
	 * @param d1
	 * @param d2
	 */
	public ArrayList<Domain> findShortestPath(Domain d1, Domain d2) {
		// TODO - implement Web.findShortestPath
	//	throw new UnsupportedOperationException();
		
		GraphAlgorithm<Domain,String> ga=new GraphAlgorithm<Domain,String>();
		ArrayList<Domain> solution=new ArrayList<Domain> ();
		
		if(net.getValues().contains(d1)&&net.getValues().contains(d2)){
			
			IGraph<Domain,String> shortPaths=ga.bfs(net,d1);
			net=shortPaths;
			finder(shortPaths,d1,d2,solution);
			
		}
		
				
		return solution;
		
		
	}
	public String organizador(String a) {
		a=a.substring(1, a.length()-1);
		String[] joda=a.split(", ");
		String retorno="";
		for (int i = 0; i < joda.length; i++) {
			retorno=retorno+"\n"+i+1+")"+joda[i];
		}
		return retorno;
	}
	
	
	
	public ArrayList<Domain> finder(IGraph<Domain,String> a,Domain act,Domain obj, ArrayList<Domain> ex) {
		
		GraphAlgorithm<Domain,String> ga=new GraphAlgorithm<Domain,String>();
		IGraph<Domain,String>aux=ga.bfs(a, act);
		
		if(act.equals(obj)){
			ex.add(obj);
			return ex;
		}else{
				Domain next=	aux.getNeighbors(act).iterator().next();
				ex.add(act);
				
				return finder(ga.bfs(a, next), next, obj, ex);
			}
		}

	/**
	 * 
	 * @param d
	 */
	public IGraph cyclesOf(Domain d) {
		GraphAlgorithm<Domain, String> algo = new GraphAlgorithm<>();
		net = algo.dfs(net);
		Vertex<Domain, String> vertexDomain = ((GraphList<Domain, String>) net).getVertex(d);
		GraphList<Domain, String> niu = new GraphList<>(true);
		for (int i = 0; i < vertexDomain.getCycleAncestors().size(); i++) {
			Vertex<Domain, String> vAux = vertexDomain.getCycleAncestors().get(i);
			String original = net.getLabel(d, vAux.getValue());
			niu.addEdge(original, d, vAux.getValue());
			while (vertexDomain != vAux) {
				Vertex<Domain, String> v2Aux = vAux.getAncestor();
				original = net.getLabel(vAux.getValue(), v2Aux.getValue());
				niu.addEdge(original, vAux.getValue(), v2Aux.getValue());
				vAux = v2Aux;
			}
		}
		if(vertexDomain.getCycleAncestors().size()>0)
		return net = niu;
//		System.out.println("igual a 0");
		return net;
	}

	public boolean changeGraphImplementation() {
		// TODO - implement Web.changeGraphImplementation
		throw new UnsupportedOperationException();
	}

	public ArrayList<Domain> getDomains() {
		return net.getValues();
	}

	public ArrayList<Object[]> getLinks() {
		return net.getEdges();
	}

}