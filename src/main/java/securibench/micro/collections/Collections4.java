/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections4.java,v 1.5 2006/04/04 20:00:41 livshits Exp $
 */
package securibench.micro.collections;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import securibench.micro.BasicTestCase;
import securibench.micro.MicroTestCase;

/**
 * @servlet description = "test of iterators"
 * @servlet vuln_count = "1"
 */
public class Collections4 extends BasicTestCase implements MicroTestCase {
	private static final String FIELD_NAME = "name";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter(FIELD_NAME);
		LinkedList ll = new LinkedList();
		ll.addLast(name);

		for (Iterator iter = ll.iterator(); iter.hasNext();) {
			PrintWriter writer = resp.getWriter();
			Object o = iter.next();

			writer.println(o); /* BAD */
		}
	}

	public String getDescription() {
		return "test of iterators";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}