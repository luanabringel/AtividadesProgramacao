# Checkout e Commit em p1

O objetivo desta atividade é simples: que você faça um ciclo
completo de uma atividade, usando o site da disciplina e o
ferramental de linha de comando que usaremos para esse fim.

## Instalação do `p1` e do `tst`

Para instalar o `p1` e o `tst` em sua conta você precisa instalar
o pacote `p1ufcg` que está disponível no
[PyPI](https://pypi.org). Para isso, você precisa executar o
seguinte comando em seu _shell_:

```bash
pip install p1ufcg
```

Para testar se você instalou a versão mais recente do `p1` e do
`tst`, você pode verificar as versões de cada um deles com os
comandos `p1 -v` e `tst -v`. As versões mínimas aceitáveis de
cada um deles são, respectivamente: `0.2.6` e `0.16.0`.

Se a versão de alguma das duas for menor que essas, faça uma
atualização do pacote com o comando abaixo:

```bash
pip install --upgrade p1ufcg
```

## `login`

O passo seguinte é fazer o login via do `p1` no site da
disciplina. Para isso, antes você precisa fazer o login através
do _browser_, no site da disciplina. Em seguida, no _shell_, use
o comando:

```bash
p1 login
```

O comando acima deve mostrar uma URL para o login e também deve
oferecer para abrir um _browser_ automaticamente na URL. Aceite e
espere o browser mostrar uma página de autorização do login.
Autorize o login, clicando no botão apropriado. Isso deve
concluir o processo de login de `p1`. Confira no terminal se o
seu email foi devidamente coletado e se o login foi autorizado.

> Se você já tinha uma instalação anterior de `p1` é possível que
> a nova versão não encontre os dados do novo site na
> configuração. Se isso ocorrer, renomeie o diretório de
> configuração antigo de `p1` e execute o `p1 login` novamente
> (isso deve criar um novo diretório de configuração). Para isso,
> use o comando `mv ~/.p1 ~/.p1.old`.

## `checkout`

Uma vez concluído o processo de login com sucesso, você pode
fazer o `checkout` das atividades. Para isso, use o comando `p1
checkout`. O comando é interativo, logo, dispensa mais
argumentos. Ele deve buscar no site as atividades abertas e
disponíveis para fazer o download e a instalação no seu diretório
`~/p1`.

Uma vez escolhida a atividade, ela será gravada em um
subdiretório de `~/p1`, de acordo com o identificador da
atividade.

> **Observação** Por ora, a modificação do diretório da atividade
> está desabilitado.

## Responda à atividade

1. No _shell_, vá para o diretório da atividade, dentro de `~/p1`
   (talvez dentro de algum outro subdiretório).
2. Liste o conteúdo do diretório. Você deve ver vários arquivos.
   Um deles é o `questoes.txt` que é o arquivo em que você deve
   trabalhar.
3. Abra o arquivo `questoes.txt` com algum editor de textos de
   terminal e responda às perguntas nele contidas, corretamente.
4. A atividade inclui testes automáticos. Para executá-los,
   apenas digite o comando `tst` no _shell_. Se as questões
   tiverem sido respondidas corretamente (de acordo com teste), a
   saída do `tst` indicará isso imprimindo um ponto `.` para cada
   teste existente.
5. Corrija sua resposta até que o `tst` indique que a resposta
   está correta.

> Os testes são, obviamente, mera verificação textual do conteúdo
> do arquivo. Se você executar os testes antes de alterar o
> arquivo verá que um teste ainda passa que é o que verifica
> apenas se um arquivo com aquele nome dado existe. Observe ainda
> que se você trocar as respostas entre as perguntas, os testes
> ainda vão passar (e as respostas estarão, tecnicamente,
> erradas).  Isso mostra uma limitação intrínsecas de testes
> automáticos que veremos mais adiante.

## `commit`

Quando sua resposta for aceita pelos testes fornecidos, você pode
fazer o _commit_ do arquivo (enviar o arquivo para o site). Para
isso, execute o seguinte comando no _shell_ (no diretório da
atividade, claro).

```bash
p1 commit questoes.txt
```

Se o commit for bem sucedido, o comando deve indicar isso. Se o
_commit_ falhar, entre em contato com os professores.


## Confira sua resposta e a entregue

No _browser_, retorne à página da atividade no site da
disciplina. No final da página, você deve identificar o arquivo
de respostas.

Confira se está tudo ok. Se estiver, você pode concluir a
atividade, clicando no botão de envio da atividade.


## Isso é tudo

Isso conclui todo o processo típico de atividades da disciplina.
Obviamente que, ao invés de responder a questões textuais, você
deverá escrever programas.
