package br.com.zup.keymanagerrest.controller

import br.com.zup.ListarChavePixRequest
import br.com.zup.ListarChavePixResponse
import br.com.zup.ListarChavePixResponse.ChavePix
import br.com.zup.ListarChavePixServiceGrpc
import br.com.zup.keymanagerrest.response.ChavePixResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import java.util.*
import javax.inject.Inject

@Validated
@Controller("/api/v1/clientes/{idCliente}")
class ListarChavePixController {

    @Inject
    lateinit var listarChavePixClient: ListarChavePixServiceGrpc.ListarChavePixServiceBlockingStub

    @Get("/pix")
    fun listarChavePix(idCliente: UUID) : HttpResponse<Any> {
        val response = listarChavePixClient.listar(ListarChavePixRequest.newBuilder()
            .setIdCliente(idCliente.toString())
            .build())

        val chaves = response.listaChavePixList.map { ChavePixResponse(it) }

        return HttpResponse.ok(chaves)
    }

}