package pl.kuchmaczpogoda.controller;

import javafx.scene.image.Image;
import org.json.JSONArray;
import pl.kuchmaczpogoda.view.ViewFactory;

public abstract class BaseController {
    protected ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }
    public String getFxmlName() {
        return fxmlName;
    }

    public static String getIconUrl(JSONArray jsonArray, int arrayIndex) {
        String weatherIconId = jsonArray.getJSONObject(arrayIndex).getJSONArray("weather").getJSONObject(0).getString("icon");
        return "http://openweathermap.org/img/wn/" + weatherIconId + "@2x.png";
    }
    public static Image setImageUrl(String url) {
        return new Image(url);
    }
    public abstract void closeWindowByX();


}
