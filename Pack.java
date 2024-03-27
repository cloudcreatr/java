import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Pack {
    public static void main(String[] args) {
        try {
            // List of IP addresses to send the message to
            List<String> ipAddresses = Arrays.asList(
                "10.10.2.16",
                "10.10.2.22",
                "10.10.5.1",
                "10.10.8.30",
                "10.10.12.27",
                "10.10.12.29",
                "10.10.100.111",
                "10.10.100.112",
                "10.14.171.102",
                "10.16.16.10",
                "10.16.16.20"
            );

            for (String ip : ipAddresses) {
                // The command to send a popup message to user "username" on each computer
                String command = "msg /SERVER:" + ip + " /TIME:10 Hello from Java!";

                // Execute the command
                Runtime.getRuntime().exec(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}