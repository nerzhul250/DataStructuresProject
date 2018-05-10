package world;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Web {
	
	private IGraph<Domain,String> net;
	
	public Web() {
		net=new GraphList<Domain,String>(true);
		Domain d1=new Domain("https://www.google.com.co","google.com.co");
		Domain d2=new Domain("https://adwords.google.com","adwords.google.com");
		net.addEdge("https://www.google.com.co/intl/en_co/ads",
				d1,d2);
	}

	/**
	 * @param startingPoint
	 * @param depth
	 * @throws IOException 
	 */
	public int expandGraph(Domain domain,String link, int depth,HashSet<String> hs) throws IOException {
		int b=0;
		if(depth>0 && !hs.contains(link)) {
			hs.add(link);
//			System.out.println(link);
			depth--;
			Document doc=null;
			try {
				doc = Jsoup.connect(link).get();				
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}
			Elements elements=doc.select("a");
//			System.out.println(elements.size());
			Iterator<Element> itLinks = elements.iterator();
			while(itLinks.hasNext()) {
				Element l=itLinks.next();
//				System.out.println(l);
				String absHref = l.attr("abs:href");
//				System.out.println(absHref);
				if(!absHref.isEmpty() && absHref!=null) {
//					System.out.println(absHref);
					String[] URL=absHref.split("//");
					String[] part=null;
					try {
						part=URL[1].split("/");						
					}catch(Exception e) {
						continue;
					}
					String name=part[0];
					if(name.substring(0,4).equals("www.")) {
						name=name.substring(4);
					}
					if(!domain.getName().equals(name)) {
						Domain newdomain=new Domain(URL[0]+"//"+part[0],name);
						boolean a=net.addEdge(link,domain,newdomain);
						if(a) {
							b+=1+expandGraph(newdomain,newdomain.getURL(),depth,hs);							
						}
					}else {
						b+=expandGraph(domain,absHref,depth,hs);
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
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param d
	 */
	public ArrayList<Domain> cyclesOf(Domain d) {
		// TODO - implement Web.cyclesOf
		throw new UnsupportedOperationException();
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