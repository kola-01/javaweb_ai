package asai.kola;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequestExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://wallpaper.apc.360.cn/index.php?c=WallPaper&a=getAppsByCategory&cid=14&start=0&count=15&from=360chrome");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            // 打印获取到的内容
            System.out.println(content.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
