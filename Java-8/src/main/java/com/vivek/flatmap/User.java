package flatmap;

import java.util.List;

class User {
   private String id;
   private List<String> email;

   public User(String id, List<String> email) {
       this.id = id;
       this.email = email;
   }

   public List<String> getEmail() {
       return email;
   }

   public void setEmail(List<String> email) {
       this.email = email;
   }

   public String getId() {
       return id;
   }

   public void setId(String id) {
       this.id = id;
   }
}
