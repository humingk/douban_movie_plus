
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport{
    private String account;
    private String password;
    private String role;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public  void setRole(String role){
        this.role=role;
    }
    public String getRole(){
        return role;
    }
    public String execute() throws Exception{
        System.out.print("execute...");
        if(account.equals(password)) {
            if (role.equals("user")){
                return "success_user";
            }else if(role.equals("admin")) {
                return "success_admin";
            }else
                return "fail";
        }else
            return "fail";
    }
}
