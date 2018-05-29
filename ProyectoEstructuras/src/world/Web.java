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
	public int expandGraph(Domain domain, String link, int depth, HashSet<String> hs) throws IOException {
		int b = 0;
		try {
			if (depth > 0 && !hs.contains(link)) {
				hs.add(link);
				depth--;
				Document doc = null;
				try {
					doc = Jsoup.connect(link).get();					
				}catch(Exception e) {
					throw new Exception(link);
				}
				Elements elements = doc.select("a");
				Iterator<Element> itLinks = elements.iterator();
				while (itLinks.hasNext()) {
					Element l = itLinks.next();
					String absHref = l.attr("abs:href");
					if (!absHref.isEmpty() && absHref != null) {
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
								b += 1 + expandGraph(newdomain, newdomain.getURL(), depth, hs);
							}
						} else {
							b += expandGraph(domain, absHref, depth, hs);
						}
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Could not connect to: "+e);
		}
		return b;
	}

	/**
	 * 
	 * @param d1
	 * @param d2
	 */
	public IGraph<Domain,String> findShortestPath(Domain d1, Domain d2) {
		GraphAlgorithm<Domain,String> ga=new GraphAlgorithm<Domain,String>();
		ArrayList<Domain> solution=new ArrayList<Domain> ();
		IGraph<Domain,String> lol=new GraphList<Domain,String>(true);
		
		
		if(net.getValues().contains(d1)&&net.getValues().contains(d2)){
			//solution.add(d2);
			
			IGraph<Domain,String>net2=ga.bfs(net, d1);
			
			Vertex<Domain, String> vertexDomain1 = ((GraphList<Domain, String>) net2).getVertex(d2);
			Vertex<Domain, String> objective = ((GraphList<Domain, String>) net2).getVertex(d1);
			
			while(!vertexDomain1.equals(objective)){
			
				solution.add(vertexDomain1.getValue());
				
			lol.addEdge(net2.getLabel(vertexDomain1.getValue(), vertexDomain1.getAncestor().getValue()), vertexDomain1.getAncestor().getValue(), vertexDomain1.getValue());
				vertexDomain1=vertexDomain1.getAncestor();
				
			}
			solution.add(d1);
		}
		return lol;
	}
	public String organizador(String a) {
		a=a.substring(1, a.length()-1);
		String[] joda=a.split(", ");
		String retorno="";
		for (int i = joda.length-1; i >=0; i--) {
			int act=joda.length-i;
			retorno=retorno+"\n"+act+")"+joda[i];
		}
		return retorno;
	}
	

	/**
	 * 
	 * @param d
	 */
	public IGraph cyclesOf(Domain d) {
		GraphAlgorithm<Domain, String> algo = new GraphAlgorithm<>();
		IGraph<Domain,String> net2 = algo.dfs(net);
		Vertex<Domain, String> vertexDomain = ((GraphList<Domain, String>) net2).getVertex(d);
		GraphList<Domain, String> niu = new GraphList<>(true);
		for (int i = 0; i < vertexDomain.getCycleAncestors().size(); i++) {
			Vertex<Domain, String> vAux = vertexDomain.getCycleAncestors().get(i);
			String original = net2.getLabel(d, vAux.getValue());
			niu.addEdge(original, d, vAux.getValue());
			while (vertexDomain != vAux) {
				Vertex<Domain, String> v2Aux = vAux.getAncestor();
				original = net2.getLabel(vAux.getValue(), v2Aux.getValue());
				niu.addEdge(original, vAux.getValue(), v2Aux.getValue());
				vAux = v2Aux;
			}
		}
		if (vertexDomain.getCycleAncestors().size() > 0)
			return net2 = niu;
		// System.out.println("igual a 0");
		return net2;
	}

	public String changeGraphImplementation() {
		net=net.transformToMyOpposite();
		if(net instanceof GraphMatrix) {
			return "Se ha cambiado de graphList a graphMatrix";
		}else {
			return "Se ha cambiado de graphMatrix a graphList";
		}
	}

	public ArrayList<Domain> getDomains() {
		return net.getValues();
	}

	public ArrayList<Object[]> getLinks() {
		return net.getEdges();
	}

	public IGraph<Domain, String> getNet() {
		return net;
	}

	public void setNet(IGraph<Domain, String> net) {
		this.net = net;
	}
}