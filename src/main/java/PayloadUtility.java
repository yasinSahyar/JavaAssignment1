import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadUtility {

    public static String createUserPayload(int id,String email,String password,long createdTimestamp,long updatedTimestamp){
        String payload = null;
        UserPayload userPayload=new UserPayload(id,email,password,createdTimestamp,updatedTimestamp);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload = objectMapper.writeValueAsString(userPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        return payload;
    }

    public static String createUserPayload(int id,String email,String password){
        String payload = null;
        UserPayload userPayload=new UserPayload(id,email,password);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload = objectMapper.writeValueAsString(userPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        return payload;
    }

    public static String createTodoPayload(int id,String name,String description,int userId,long createdTimestamp,long updatedTimestamp,String status){
        String payload = null;
        UserPayload userPayload=new UserPayload(id,name,description,userId,createdTimestamp,updatedTimestamp,status);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload = objectMapper.writeValueAsString(userPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        return payload;
    }


}