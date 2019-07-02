# Poker

## ポーカーゲーム  
  
### <概要>  
チップの賭けなしverポーカーをプレイします！  
まず、初めに5枚のカードが配られます。その後、交換したいカードを選び交換していきます。より強いカードの組み合わせ(役)を目指しましょう！  
  
  
## cmd上でプレイされる場合
  
### <コンパイル手順>  
ポーカーをプレイするためにはコンパイルが必要となります。cmd上でソースコードのコンパイルをする手順を説明します。まず、適当な場所にディレクトリを作成し、こちらのPokerリポジトリをcloneしてください。
例として、copyという名前のディレクトリを作成し、ここにcloneします。    
　　　　　`mkdir copy`  
　　　　　`git clone https://github.com/Hiroyuki0210/Poker copy`  
Cloneされたディレクトリ内にsrcディレクトリがあることを確認し、srcディレクトリに進みます。そして、srcディレクトリ内にあるPlayPoker.javaを下のようにコンパイルします。  
　　　　　`javac -encoding UTF-8 PlayPoker.java`  
ここで、PlayPoker.javaにはUTF-8の文字コードを使用していますので、コンパイルの際にエンコードしています。PlayPoker.javaをコンパイルすると、そのソースファイルにおいて参照されたクラスがあるファイル(cardディレクトリ内のCard.java、Deck.java、Suit.java と Judgeディレクトリ内のJudge.java、JudgeParam.java、Judgement.java)もコンパイルされ、それぞれのclassファイルが作成されます。  
　　　　　(ex) cardディレクトリ内に Card.class 、 Deck.class 、Suit.class　が作成。  
        
  
### <実行方法>  
まず、cmd上でPlayPoker.classがあるディレクトリまで進んでください。そして、  
　　　　　`chcp  65001`  
　　　　　`java -Dfile.encoding=UTF-8 PlayPoker`  
と入力していただくと、ゲームが始まります。ここで、1行目では chcp 65001 でcmd側の文字コードをUTF-8に、2行目では -Dfile.encoding=UTF-8 でclassファイルの文字コードをUTF-8 にそれぞれエンコードしています。  

  
### <操作説明>  
1.　PlayPokerを実行していただくと, startの記入を求められるので start を記入します。  
　　　　　Let's do Poker!! Write start  
　　　　　> start  
2.　5枚のカードが配られます。特別な組み合わせ(役)がある場合は、手札の下に表示されます。  
　　　　　(ex)　手札 : 　♦5　♥8　♦11　♥13　♦13  
　　　　　　　　1ペア 　← 役  
3.　カードを交換します。手札内に不要なカードがあればそのカード番号を入力してください。カード番号は左から0,1,2,3,4と割り振られております。  
　　　※ 複数交換したい場合は、 "," で区切って入力してください。  
　　　　　(ex)　手札 : 　♦5　♥8　♦11　♥13　♦13  
　　　　　　　　♦5　♥8　♦11が不要　→　0,1,2 と入力    
4.　カード交換を3回行います。  
  
  
  
## ブラウザ上でプレイされる場合
  
### <ディレクトリの配置とコンパイル方法>
　jspファイルを実行するには、Webコンテナが必要となります。その代表的なものとしてtomcatがあります。ここでは、tomcatを用いたjspファイルの実行方法をご紹介します。tomcatをインストールされていない方は, <a href="http://tomcat.apache.org/download-90.cgi">こちら</a>からインストールをしてください。  
まず、tomcatディレクトリ内のwebappsディレクトリに"Poker"という名前のフォルダを作成してください。  
`tomcat　→　webapps　→　Pokerフォルダを作成`  
そして、このページにおいてあるWebContentディレクトリとsrcディレクトリをそれぞれダウンロードして、Pokerフォルダ内に挿入してください。  
`Poker　→　WebContent , src`  
以上で、ディレクトリの配置は完了です。続いて、コンパイルの手順を説明します。今回は、jspとサーブレットの連携で動作します。jspファイルはtomcatの方で自動コンパイルしてくれますが、サーブレットファイルやその他のjavaファイルに関しては各自コンパイルしていただく必要があります。以下、コンパイルの手順です。  
1. javaファイルは全てsrcディレクトリ内に含まれていますので、まずはcmdでsrcディレクトリまで進みます。  
2. 各パッケージに含まれるソースコードをコンパイルします。以下の3つのコマンドを入力していただくと、全てのソースコードをコンパイルできます。
```
javac -encoding UTF-8 judge\*.java
javac -encoding UTF-8 card\Deck.java
javac -classpath .;"servlet-api.jarがあるクラスパス" -encoding UTF-8 game\*.java
```
3つ目のコマンドでservlet-api.jarとありますが、こちらはtomcat内に含まれており、Tomcat　→　lib　→　servlet-api.jar においてあります。これで、コンパイルの操作は終了です。
   
### <実行方法と操作説明>  
まず、ブラウザを開き、`http://localhost:8080/Poker/top.jsp` というURLを入力してください。すると、以下のような画面が表示されます。  

![image](https://user-images.githubusercontent.com/51352734/60483686-81b91880-9cd1-11e9-93ad-b37d56e7b89a.png)

うまく画面が表示されない場合は、先の <ディレクトリの配置とコンパイル方法> で誤った操作をしていないかご確認ください。  
#### 失敗例
・webappsディレクトリに"Poker"という名前のフォルダが作られていない  
・srcディレクトリ内にコンパイルされていないソースコードがある  
  
上の画面が表示されたら、"スタート"ボタンをクリックし、Pokerゲームを開始します。  
ゲーム開始後、以下の画面のように5枚の手札が配られます。役がある場合は、カード下に表示されます。交換したいカードがある場合は、カード番号の横にあるチェックボックスにチェックを入れ、"交換する"ボタンを押してください。交換するカードがない場合は、"このまま勝負する"ボタンを押してください。    
![image](https://user-images.githubusercontent.com/51352734/60483897-6995c900-9cd2-11e9-963d-ba34dbe3f9be.png)  
交換回数は最大で3回までです。交換が終わると結果画面が表示され、"ゲームを終了する"を押すとトップ画面に戻ります。  
![image](https://user-images.githubusercontent.com/51352734/60484198-97c7d880-9cd3-11e9-80d5-eed0891e1e18.png)  
