package co.uehr.uka.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class ErrorResponse {
        @JsonProperty("code")
        private int code;
        @JsonProperty("message")
        private String message;

        public ErrorResponse(int code, String message) {
                this.code = code;
                this.message = message;
        }
}