
package endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-735-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Hello", targetNamespace = "http://endpoint/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Hello {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHello", targetNamespace = "http://endpoint/", className = "endpoint.GetHello")
    @ResponseWrapper(localName = "getHelloResponse", targetNamespace = "http://endpoint/", className = "endpoint.GetHelloResponse")
    @Action(input = "http://endpoint/Hello/getHelloRequest", output = "http://endpoint/Hello/getHelloResponse")
    public String getHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}