package br.com.zup.keymanagerrest.factory

import br.com.zup.BuscarChavePixServiceGrpc
import br.com.zup.CadastrarChavePixServiceGrpc
import br.com.zup.ListarChavePixServiceGrpc
import br.com.zup.RemoverChavePixServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class KeyManagerGRPCFactory (@GrpcChannel("chavePix") val channel: ManagedChannel) {

    @Singleton
    fun cadastrarChavePix() = CadastrarChavePixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun removerChavePix() = RemoverChavePixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun buscarChavePix() = BuscarChavePixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listarChavePix() = ListarChavePixServiceGrpc.newBlockingStub(channel)

}