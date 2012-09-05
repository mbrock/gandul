package se.mbrock.gandul.web;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    // TODO: You should configure this appropriately for
    // your environment
    private static final String LOG_PATH =
            "./logs/access/yyyy_mm_dd.request.log";

    private static final String WEB_XML =
            "src/main/webapp/WEB-INF/web.xml";
    private static final String CLASS_ONLY_AVAILABLE_IN_IDE =
            "com.sjl.IDE";
    private static final String PROJECT_RELATIVE_PATH_TO_WEBAPP =
            "src/main/java/META-INF/gandul";

    public static interface WebContext
    {
        public File getWarPath();
        public String getContextPath();
    }


    private Server server;
    private int port;
    private String bindInterface;

    public HelloWorld(int aPort)
    {
        this(aPort, null);
    }

    public HelloWorld(int aPort, String aBindInterface)
    {
        port = aPort;
        bindInterface = aBindInterface;
    }

    public void start() throws Exception
    {
        server = new Server();

        server.setThreadPool(createThreadPool());
        server.addConnector(createConnector());
        server.setHandler(createHandlers());
        server.setStopAtShutdown(true);

        server.start();
    }

    public void join() throws InterruptedException
    {
        server.join();
    }

    public void stop() throws Exception
    {
        server.stop();
    }

    private ThreadPool createThreadPool()
    {
        // TODO: You should configure these appropriately
        // for your environment - this is an example only
        QueuedThreadPool _threadPool = new QueuedThreadPool();
        _threadPool.setMinThreads(10);
        _threadPool.setMaxThreads(100);
        return _threadPool;
    }

    private SelectChannelConnector createConnector()
    {
        SelectChannelConnector _connector =
                new SelectChannelConnector();
        _connector.setPort(port);
        _connector.setHost(bindInterface);
        return _connector;
    }

    private HandlerCollection createHandlers()
    {
        WebAppContext _ctx = new WebAppContext();
        _ctx.setContextPath("/");

        if(isRunningInShadedJar())
        {
            _ctx.setWar(getShadedWarUrl());
        }
        else
        {
            _ctx.setWar(PROJECT_RELATIVE_PATH_TO_WEBAPP);
        }

        List<Handler> _handlers = new ArrayList<Handler>();

        _handlers.add(_ctx);

        HandlerList _contexts = new HandlerList();
        _contexts.setHandlers(_handlers.toArray(new Handler[0]));

        RequestLogHandler _log = new RequestLogHandler();
        _log.setRequestLog(createRequestLog());

        HandlerCollection _result = new HandlerCollection();
        _result.setHandlers(new Handler[] {_contexts, _log});

        return _result;
    }

    private RequestLog createRequestLog()
    {
        NCSARequestLog _log = new NCSARequestLog();

        File _logPath = new File(LOG_PATH);
        _logPath.getParentFile().mkdirs();

        _log.setFilename(_logPath.getPath());
        _log.setRetainDays(90);
        _log.setExtended(false);
        _log.setAppend(true);
        _log.setLogTimeZone("GMT");
        _log.setLogLatency(true);
        return _log;
    }

    private boolean isRunningInShadedJar()
    {
        try
        {
            Class.forName(CLASS_ONLY_AVAILABLE_IN_IDE);
            return false;
        }
        catch(ClassNotFoundException anExc)
        {
            return true;
        }
    }

    private URL getResource(String aResource)
    {
        return Thread.currentThread().
                getContextClassLoader().getResource(aResource);
    }

    private String getShadedWarUrl()
    {
        String _urlStr = getResource(WEB_XML).toString();
        // Strip off "WEB-INF/web.xml"
        return _urlStr.substring(0, _urlStr.length() - 15);
    }
}