#language:pt
#coding: utf-8

Funcionalidade: Validar as funcionalidade da calculadora do windowns
  Como um usuário
  Eu quero validar as funcionalidades da calculadora

#  Contexto: Deve iniciar as configurações default
#    Dado que inicia os headers da requisição para api "clienteAtendimento"

  @example
  Esquema do Cenário: Validar a multiplicação entre 8x9
    Dado que estou com o aplicativo iniciado
    Quando seleciono o numero "<number1>"
    E seleciono a operação "<operation>"
    E seleciono o numero "<number2>"
    E seleciono para obter o resultado
    Então o resultado é "<result>"

    Exemplos:
    |number1|number2|result|operation|
    |8      |9      |72    |multiply |
    |7      |7      |49    |multiply |