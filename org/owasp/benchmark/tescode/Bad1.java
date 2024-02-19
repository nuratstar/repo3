
package org.owasp.benchmark.testcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;

@WebServlet(value = "/cmdi-00/BenchmarkTest00006")
public class bad1 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // some code
    response.setContentType("text/html;charset=UTF-8");

    String param = "";
    if (request.getHeader("BenchmarkTest00006") != null) {
      param = request.getHeader("BenchmarkTest00006");
    }

    // URL Decode the header value since req.getHeader() doesn't. Unlike
    // req.getParameter().
    param = java.net.URLDecoder.decode(param, "UTF-8");

    String url = "https://" + param;

    // ruleid: tainted-ssrf
    new URL(url).openConnection();
    // ruleid: tainted-ssrf
    new URL(url).openStream();
    // ruleid: tainted-ssrf
    new URL(url).getContent();

  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // some code
    response.setContentType("text/html;charset=UTF-8");

    String param = "";
    if (request.getHeader("BenchmarkTest00006") != null) {
      param = request.getHeader("BenchmarkTest00006");
    }

    // URL Decode the header value since req.getHeader() doesn't. Unlike
    // req.getParameter().
    param = java.net.URLDecoder.decode(param, "UTF-8");

    String url = "https://" + param;
    URL myUrl = new URL(url);

    // ruleid: tainted-ssrf
    new URL(url).openConnection();
    // ruleid: tainted-ssrf
    myUrl.openConnection();
    // ruleid: tainted-ssrf
    new URL(url).openStream();
    // ruleid: tainted-ssrf
    myUrl.openStream();
    // ruleid: tainted-ssrf
    new URL(url).getContent();
    // ruleid: tainted-ssrf
    myUrl.getContent();

    String url2 = "https://localhost/";
    URL myUrl2 = new URL(url2);

    // ok: tainted-ssrf
    new URL(url2).openConnection();
    // ok: tainted-ssrf
    myUrl2.openConnection();
    // ok: tainted-ssrf
    new URL(url2).openStream();
    // ok: tainted-ssrf
    myUrl2.openStream();
    // ok: tainted-ssrf
    new URL(url2).getContent();
    // ok: tainted-ssrf
    myUrl2.getContent();

  }
}
