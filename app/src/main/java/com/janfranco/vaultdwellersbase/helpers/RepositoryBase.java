package com.janfranco.vaultdwellersbase.helpers;

import com.janfranco.vaultdwellersbase.entities.Result;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryBase {

    public <E> void query(Call<Result<E>> call, ResultCallback<E> callback) {
        call.enqueue(new Callback<Result<E>>() {
            @Override
            public void onResponse(Call<Result<E>> call, Response<Result<E>> response) {
                if (response.isSuccessful())
                    callback.onSuccess(response.body().getData());
                else {
                    try {
                        String errorMessage = new ErrorParser().getMessage(response.errorBody().string());
                        callback.onFailure(errorMessage);
                    } catch (IOException e) {
                        callback.onFailure(e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<Result<E>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

}
