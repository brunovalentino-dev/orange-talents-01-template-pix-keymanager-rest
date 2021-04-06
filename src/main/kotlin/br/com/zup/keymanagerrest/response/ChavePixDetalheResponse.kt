package br.com.zup.keymanagerrest.response

import br.com.zup.BuscarChavePixResponse
import br.com.zup.TipoConta
import io.micronaut.core.annotation.Introspected
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Introspected
class ChavePixDetalheResponse (response: BuscarChavePixResponse) {

    val idChavePix = response.idChavePix
    val tipoChavePix = response.chavePix.tipoChavePix
    val chavePix = response.chavePix.chavePix
    val criadaEm = response.chavePix.criadaEm.let {
        LocalDateTime.ofInstant(Instant.ofEpochSecond(it.seconds, it.nanos.toLong()), ZoneOffset.UTC)
    }
    val tipoConta = when (response.chavePix.conta.tipoConta) {
        TipoConta.CONTA_CORRENTE -> "CONTA_CORRENTE"
        TipoConta.CONTA_POUPANCA -> "CONTA_POUPANCA"
        else -> "CONTA_DESCONHECIDA"
    }
    val conta = mapOf(Pair("tipoConta", tipoConta),
        Pair("instituicao", response.chavePix.conta.instituicao),
        Pair("nomeTitular", response.chavePix.conta.nomeTitular),
        Pair("cpfTitular", response.chavePix.conta.cpfTitular),
        Pair("agencia", response.chavePix.conta.agencia),
        Pair("numeroConta", response.chavePix.conta.numeroConta))
}