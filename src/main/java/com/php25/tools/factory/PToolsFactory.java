package com.php25.tools.factory;

import com.php25.tools.*;
import com.php25.tools.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 2014/9/1.
 */
public class PToolsFactory {
    private static PToolsFactory _instance;
    private Map<Class,Object> container;

    private PToolsFactory() {
        container = new HashMap<Class,Object>();
        container.put(DigestTool.class, new DigestToolImpl());
        container.put(StringTool.class,new StringToolImpl());
        container.put(FileTool.class,new FileToolImpl((StringTool)container.get(StringTool.class)));
        container.put(HttpTool.class,new HttpToolImpl((StringTool)container.get(StringTool.class)));
        container.put(PageTool.class,new PageToolImpl());
        container.put(RandomTool.class,new RandomToolImpl((StringTool)container.get(StringTool.class)));
        container.put(RegexTool.class,new RegexToolImpl());
        container.put(SerializeTool.class,new SerializeToolImpl());
        container.put(StringTool.class,new StringToolImpl());
        container.put(TimeTool.class,new TimeToolImpl());
    }

    public synchronized static PToolsFactory getInstance() {
        if(_instance == null) {
            _instance = new PToolsFactory();
        }
        return _instance;
    }

    public DigestTool getDigestTool() {
        return (DigestTool)container.get(DigestTool.class);
    }

    public FileTool getFileTool() {
        return (FileTool)container.get(FileTool.class);
    }

    public HttpTool getHttpTool() {
        return (HttpTool)container.get(HttpTool.class);
    }

    public PageTool getPageTool() {
        return (PageTool)container.get(PageTool.class);
    }

    public RandomTool getRandomTool() {
        return (RandomTool)container.get(RandomTool.class);
    }

    public RegexTool getRegexTool() {
        return (RegexTool)container.get(RegexTool.class);
    }

    public SerializeTool getSerializeTool() {
        return (SerializeTool)container.get(SerializeTool.class);
    }

    public StringTool getStringTool() {
        return (StringTool)container.get(StringTool.class);
    }

    public TimeTool getTimeTool() {
        return (TimeTool)container.get(TimeTool.class);
    }

}
