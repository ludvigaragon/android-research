package com.github.android.research.mock.server.infrastructure;


import com.github.android.research.mock.server.domain.model.Research;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class MockResponseFactory {

    private final Gson gson;

    public MockResponseFactory() {
        gson = new GsonBuilder().disableHtmlEscaping().create();
    }

    public String loginSuccess() {
        ServiceResponse authResponseMock = new ServiceResponse();
        authResponseMock.code = "0000";
        authResponseMock.message = "Sucesso";
        return gson.toJson(authResponseMock);
    }

    public String loginFail() {
        ServiceResponse authResponseMock = new ServiceResponse();
        authResponseMock.code = "9999";
        authResponseMock.message = "Login ou senha inválidos. Tente novamente.";
        return gson.toJson(authResponseMock);
    }

    public String researchSuccess() {
        ResearchResponse researchResponse = new ResearchResponse();
        researchResponse.code = "0000";
        researchResponse.message = "Sucesso";
        researchResponse.researches = new ArrayList<>();
        researchResponse.researches.add(new Research(1, "Android ou Iphone", "Duas grandes potencias, dois públicos alvos distintos, em qual voce se encaixa?"));
        researchResponse.researches.add(new Research(2, "Windows ou Linux", "Microsoft a maior potência de Sistemas Operacionais do mundo, estaria ameaçado de perder seu reinado para o Linux?"));
        researchResponse.researches.add(new Research(3, "PhotoShop ou Corel PhotoPaint", "Dois softwares que prometem realizar fantasticas edições em imagens com ferramentas incríveis"));
        return gson.toJson(researchResponse);
    }

    public String unauthorized() {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.code = "0401";
        serviceResponse.message = "Operação não autorizada";
        return gson.toJson(serviceResponse);
    }
}
