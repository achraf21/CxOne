package bean;

import com.mysql.jdbc.Util;
import org.xml.sax.XMLReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.*;
import java.nio.file.Path;
import javax.jms.Message;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.Locale;
import java.util.logging.Logger;
import javax.jms.Message;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.owasp.encoder.Encode;
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.apache.commons.lang3.StringUtils;

import java.net.URI;

import org.apache.commons.io.FilenameUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static org.owasp.encoder.Encoders.URI;

import com.github.pukkaone.jsp.*;
import org.apache.commons.lang3.SerializationUtils;
/**
 *
 * @author alakdim
 */
public class NewMain {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
       //System.out.println(EscapeXml.escape("AAAA : <script>"));
               
       String alphabets ="A B C D E F G H I J L K M N O P Q R S T U V W X Y ";
        String A= "<script>alert('XSS');</script>";
        
        System.out.println("ENCODER FOR HTML : "+URLDecoder.decode(";", "UTF-8"));
        
        System.out.println("ENCODER FOR HTML : "+URLEncoder.encode(";", "UTF-8")); 
       
       
//        encoder();
//        JsonResponse();
        //normalize();
        
//        String nom = "achraf <script> alert(document.cookie);</script>";
//       byte[] data =SerializationUtils.serialize(nom);
//            System.out.println(data);
//       Object object = SerializationUtils.deserialize(data);
//        System.out.println(object);

    }
    
    
    public static void parser(String urls){
        try {
             URL url = new URL(urls);
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser parser = factory.newSAXParser();
      XMLReader xmlreader = parser.getXMLReader();
      
      
        } catch (Exception e) {
        }

        try {
            Long a=Long.parseLong(urls);
            System.out.println(a);
        } catch (Exception e) { 
            e.printStackTrace();
        }


    }
    
    public static void encoder(){
        //        String A="or'1'='1";
        String alphabets ="A B C D E F G H I J L K M N O P Q R S T U V W X Y ";
        String A= "<script>alert('XSS');</script>";
        
        String Caracteres_speciaux = " ' \t < \t  > \t  : \t  / \t  | \t  , \t  ? \t  ! \t - \t _ \t = \t ! \t %  "; 
        System.out.println("ToString() : "+Caracteres_speciaux.toString());
        System.out.println("ENCODER FOR JAVA : "+Encode.forJava(Caracteres_speciaux));
        System.out.println("ENCODER FOR HTML : "+Encode.forHtml(Caracteres_speciaux));
        System.out.println("ENCODER FOR XML : "+Encode.forXml(Caracteres_speciaux));
        System.out.println("FOR JAVASCRIPT : "+Encode.forJavaScript(Caracteres_speciaux));
        System.out.println("FOR URI : "+Encode.forUri(Caracteres_speciaux));
//        System.out.println("StringEscapeUtils.escapeSql : "+StringEscapeUtils.escape(Caracteres_speciaux));
//        System.out.println("StringEscapeUtils.escapeHtml: "+StringEscapeUtils.escapeHtml3(Caracteres_speciaux));
//        System.out.println("StringEscapeUtils.escapeXML: "+StringEscapeUtils.escapeXml(Caracteres_speciaux));
    }
    
    public static void normalize(){
        try{
            
//            File f = new File("../foo/aa/bb/..");
//            System.out.println(f.getCanonicalFile());
//            String normalized = new URI("../foo/").normalize().getPath();
//            System.out.println(normalized);
//            //File file=new File("C:\\Users\\ALAKDIM\\Desktop\\Python\\python_app");
//            String a = FilenameUtils.normalize("foo/achraf/..");
//            System.out.println(a);
                //File file = new File();
                //String filename= FilenameUtils.normalize("file:///C:/Users/ALAKDIM/Downloads/6ee6d38a-6b97-4735-ab43-bc9211e7d3aa.pdf");
                //FileInputStream file1 = new FileInputStream(filename);
                File file2 = new File ("file:///C:/Users/ALAKDIM/Downloads/6ee6d38a-6b97-4735-ab43-bc9211e7d3aa.pdf");
                //System.out.println(filename);
                
                //System.out.println(file1.getCanonicalPath());
                //System.out.println("File 1 : "+(file1.available()));
                System.out.println("File 2 : "+(file2.getAbsoluteFile()));
//                URI uri = file1.toURI().normalize();
//                System.out.println(uri);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void logger(){
                Logger logger = Logger.getLogger(NewMain.class.getName()); 
  
        // Call info method 
        String msg ="<script>alert(document.cookie)<script/>";
        logger.info("This is message 1"+msg); 
        logger.info("This is message 2"); 
        logger.info("This is message 3"); 
        logger.info("This is message 4"); 
    }
    
    public static void JsonResponse(){
        String Caracteres_speciaux = " ' \t < \t  > \t  : \t  / \t  | \t  , \t  ? \t  ! \t - \t _ \t = \t ! \t %  "; 
        String script ="<script>alert('JSON nom');</script>";
            String message="";
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("nom",script);
            //json.put("prenom", "<script>alert('JSON Nom');</script>");
            message = jsonResponse.toString();
            System.out.println(Encode.forHtml(message));
    }
}
