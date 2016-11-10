package br.com.code4u.udacity.service;

import br.com.code4u.udacity.model.CatalgoUdacity;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by felipepaiva on 10/11/16.
 */

public interface UdacityServicos {

    public static final String URL_BASE = "https://www.udacity.com/public-api/v0/";

    @GET("courses")
    Call<CatalgoUdacity> listaCatalogo();
}
