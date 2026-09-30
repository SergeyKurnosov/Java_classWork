package task_3;


import com.google.gson.annotations.Expose;

import java.util.List;

public record User(@Expose String login, String password, @Expose Address address, @Expose List<String> hobbies) {
}
