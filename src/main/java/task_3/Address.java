package task_3;

import com.google.gson.annotations.Expose;

public record Address(@Expose String city, @Expose String street) {
}
