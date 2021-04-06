package br.com.zup.keymanagerrest.request

import br.com.zup.TipoConta

enum class TipoContaRequest (val request: TipoConta) {

    CONTA_CORRENTE(TipoConta.CONTA_CORRENTE),
    CONTA_POUPANCA(TipoConta.CONTA_POUPANCA);

}
