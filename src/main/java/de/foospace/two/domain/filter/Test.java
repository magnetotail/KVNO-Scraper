package de.foospace.two.domain.filter;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

class Test {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"searchText\":\"\",\"near\":25,\"address\":\"45145\",\"page\":1,\"pageSize\":10,\"UserLocation\":{\"Lat\":51.4457967,\"Lng\":6.9761637},\"filterModel\":{\"fremdsprachenFilter\":[],\"geschlechtFilter\":[],\"fachgebieteFilter\":[],\"schwerpunkteFilter\":[],\"zusatzbezeichnungFilter\":[],\"behandlungsprogrammFilter\":[],\"psychotherapieVerfahrenFilter\":[\"Verhaltenstherapie für Erwachsene\"],\"barrierefreiheitFilter\":[],\"erreichbarkeitTagFilter\":[],\"erreichbarkeitZeitFilter\":[]}}");
        Request request = new Request.Builder()
                .url("https://arztsuche.kvno.de/api/api/places/possiblefilters")
                .post(body)
                .addHeader("cookie", "TS01dceb35=015f6b75ab7b0592fb6a9a60111fe2a8b0872d6b57b03453c9a16e153567eba1d48c8dd1ac1d2bae5277b7be3d09d20ae326db3687; __cmpconsentx52593=BPxdI4DPxdI4DAfJRBDEABAAAAAAAA; __cmpconsentx52491=BPxdIJ5PxdIJ5AfHrBDEABAAAAAAAA; __cmpcccx52593=aBPxdI4DgAgAzACAAuCjQAAA; __cmpcccx52491=aBPxdIJ5gAAAgAXAAA; TS01dceb35=015f6b75abfaf7c164d935416177dc127e688f72ef9546c962acaa731d4d9717c9fd8ad5a17603b74af62d830197c6d2edb789f109")
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "Insomnia/2023.5.7")
                .build();

        Response response = client.newCall(request).execute();

        FilterModel model = new Gson().fromJson(response.body().string(), FilterModel.class);

//        model.getPsychotherapieVerfahrenFilter().forEach(System.out::println);
//        model.

    }
}