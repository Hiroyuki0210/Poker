# Poker

## ポーカーゲーム  
  
### <概要>  
チップの賭けなしverポーカーをプレイします！  
まず、初めに5枚のカードが配られます。その後、交換したいカードを選び交換していきます。より強いカードの組み合わせ(役)を目指しましょう！  
  

##  プロジェクトの導入とポーカーゲームのURL取得  
　まず、cmdを用いて、Pokerプロジェクトをクローンします。  
 `git clone https://github.com/Hiroyuki0210/Poker.git`  
 続いて、ルートディレクトリ(Pokerディレクトリ)上で  
 `gradlew tomcatRunWar`  
 というコマンドを入力していただくと、次のように表示されます。    
 ```
Starting a Gradle Daemon (subsequent builds will be faster)

> Task :tomcatRunWar
Started Tomcat Server
The Server is running at http://localhost:8080/Poker
<==========---> 80% EXECUTING [38m 1s]
> :tomcatRunWar
 ```  
 このような画面が表示されたら、tomcatが起動している状態なので、あとはブラウザ上で  
 `http://localhost:8080/Poker/top.jsp`  
 を入力すると、ポーカーが始まります。  
 上のような画面が表示されない場合は、ディレクトリ構造などが誤っている可能性がありますので、確認してください。  
 (補足)  
 ・ポーカーゲームのURL取得にはgradleというビルドツールの機能を使っています。今回、gradleをインストールしていただかなくても、URLを取得できたのはPokerプロジェクト内にgradleの機能を使えるようにするファイルがあるためです。gradleに関する詳しい説明は<a href="https://gradle.org/">こちら</a>から。  
 ・tomcatを停止させたい場合は、cmd上で Ctrl + c を入力すると、バッチジョブを終了しますかという内容の質問が表示されるので、yesと答えてください。  
 
   
## プレイ方法
まず、ブラウザを開き、`http://localhost:8080/Poker/top.jsp` というURLを入力してください。すると、以下のような画面が表示されます。  

![image](https://user-images.githubusercontent.com/51352734/60850771-c0982280-a22b-11e9-8e3e-914fb15d8a25.png)  



うまく画面が表示されない場合は、先の <ディレクトリの配置とコンパイル方法> で誤った操作をしていないかご確認ください。  
#### 失敗例
・webappsディレクトリに"Poker"という名前のフォルダが作られていない  
・srcディレクトリ内にコンパイルされていないソースコードがある  
  
上の画面が表示されたら、"スタート"ボタンをクリックし、Pokerゲームを開始します。  
ゲーム開始後、以下の画面のように5枚の手札が配られます。役がある場合は、カード下に表示されます。交換したいカードがある場合は、カード番号の横にあるチェックボックスにチェックを入れ、"交換する"ボタンを押してください。交換するカードがない場合は、"このまま勝負する"ボタンを押してください。    
![image](https://user-images.githubusercontent.com/51352734/60850877-1e2c6f00-a22c-11e9-8db2-79bd015d778a.png)  
交換回数は最大で3回までです。交換が終わると結果画面が表示され、"ゲームを終了する"を押すとトップ画面に戻ります。  
![image](https://user-images.githubusercontent.com/51352734/60850942-6186dd80-a22c-11e9-8845-c3fde9afea53.png)    
