/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ManyContextServer.java class
*
* @name    : ManyContextServer.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 31, 2021
****************************************************************************/

package experimental_service.HttpServerMocks;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import experimental_service.controllers.InternalController;
import lombok.extern.log4j.Log4j2;

@Log4j2
class WelcomePageHaner implements HttpHandler {
	private final String httpResponse = "<html><body bgcolor = \"gray\"><h1>Welcome</h1></body></html>";
	
	public WelcomePageHaner() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
		httpExchange.sendResponseHeaders(200, httpResponse.getBytes().length);
		OutputStream os = httpExchange.getResponseBody();
		os.write(httpResponse.getBytes());
		os.close();
    }
}

@Log4j2
class PageHandlerOne implements HttpHandler {
	private final String httpResponse = "<html><body bgcolor = \"gray\"><h1>Page One!</h1></body></html>";
	
	public PageHandlerOne() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
		httpExchange.sendResponseHeaders(200, httpResponse.getBytes().length);
		OutputStream os = httpExchange.getResponseBody();
		os.write(httpResponse.getBytes());
		os.close();
    }
}

@Log4j2
class PageHandlerTwo implements HttpHandler {
	private final String httpResponse = "<html><body bgcolor = \"gray\"><h1>Page Two!</h1></body></html>";
	
	public PageHandlerTwo() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
		httpExchange.sendResponseHeaders(200, httpResponse.getBytes().length);
		OutputStream os = httpExchange.getResponseBody();
		os.write(httpResponse.getBytes());
		os.close();
    }
}

public class SampleHttpServer {
	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 8080), 0);
		server.createContext("/", new WelcomePageHaner());
		server.createContext("/one", new PageHandlerOne());
		server.createContext("/two", new PageHandlerTwo());
		server.start();
	}
}
