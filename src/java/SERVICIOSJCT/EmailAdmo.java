package SERVICIOSJCT;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailAdmo {
    
    public boolean enviarCorreo(String de2, String clave2, String para2, String mensaje2, String asunto2){
        boolean enviado = false;
            try{
            
                String host = "smtp.gmail.com";
                Properties prop = System.getProperties();
                
                prop.put("mail.smtp.starttls.enable","true");
                prop.put("mail.smtp.host", host);
                prop.put("mail.smtp.user",de2);
                prop.put("mail.smtp.password", clave2);
                prop.put("mail.smtp.port",587);
                prop.put("mail.smtp.auth","true");
                
                Session sesion = Session.getDefaultInstance(prop,null);
                
                MimeMessage message = new MimeMessage(sesion);
                message.setFrom(new InternetAddress(de2));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(para2));
                message.setSubject(asunto2);
                message.setText(mensaje2);
                
                Transport transport = sesion.getTransport("smtp");
                transport.connect(host,de2,clave2);
                transport.sendMessage(message, message.getAllRecipients()); 
                transport.close();
                
                enviado = true;
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        return enviado;
    }
    
}
