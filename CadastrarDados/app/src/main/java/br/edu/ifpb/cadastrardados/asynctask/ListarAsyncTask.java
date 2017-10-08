package br.edu.ifpb.cadastrardados.asynctask;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.cadastrardados.Pessoa;

/**
 * Created by Henrique on 05/10/2016.
 */
public class ListarAsyncTask extends AsyncTask< String, Void, List<Pessoa> > {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Pessoa> doInBackground(String... strings) {
        String urlString = strings[0];
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();

            InputStream instream = connection.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(instream, "UTF-8"));

            pessoas = getPessoas(reader);
            instream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return pessoas;
        }
    }

    public List<Pessoa> getPessoas(JsonReader reader) throws IOException {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        reader.beginArray();

        while (reader.hasNext()) {
            pessoas.add(getPessoa(reader));
        }

        reader.endArray();
        return pessoas;
    }

    public Pessoa getPessoa(JsonReader reader) throws IOException {
        String nome = "",email = "",endereco= "",cpf = "";

        reader.beginObject();

        while (reader.hasNext()) {
            String obj = reader.nextName();
            if (obj.equals("nome")) {
                nome = reader.nextString();

            } else if (obj.equals("email")) {
                email = reader.nextString();

            } else if (obj.equals("endereco")) {
                endereco = reader.nextString();

            } else if (obj.equals("user")) {
                cpf = reader.nextString();

            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Pessoa(nome, email,endereco, cpf);
    }

    @Override
    protected void onPostExecute(List<Pessoa> result){
        super.onPostExecute(result);
    }
}
