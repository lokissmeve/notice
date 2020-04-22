package warehousepf;

import warehousepf.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverInStock_Notice(@Payload InStock inStock){

        if(inStock.isMe()){
            System.out.println("##### listener Notice : " + inStock.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_Notice(@Payload Shipped shipped){

        if(shipped.isMe()){
            System.out.println("##### listener Notice : " + shipped.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverObsolete_Notice(@Payload Obsolete obsolete){

        if(obsolete.isMe()){
            System.out.println("##### listener Notice : " + obsolete.toJson());
        }
    }

}
