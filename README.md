# Poker

## ポーカーゲーム  
  
### 概要 
チップの賭けなしverポーカーをプレイします！  
まず、初めに5枚のカードが配られます。その後、交換したいカードを選び交換していきます。より強いカードの組み合わせ(役)を目指しましょう！  
ポーカーゲームは、CLI版とブラウザ版を用意しています。  
  
  
###  プロジェクトの導入  
　cmdでPokerプロジェクトをクローンします。  
 `git clone https://github.com/Hiroyuki0210/Poker.git`  
  
  
### CLI版ポーカーゲーム  
#### ゲーム開始コマンド  
ルートディレクトリ(Pokerディレクトリ)上で  
`gradlew run`  
を入力すると、次のようにゲームが開始します。  
```
Starting a Gradle Daemon, 2 incompatible and 1 stopped Daemons could not be reused, use --status for details

> Task :run
初めのカードが配られました。

手札 : ♥2　　♣3　　♦5　　♦J　　♦K　　
役   : なし

交換したいカードの番号を選んでください。
番号は左から0,1,2,3,4となっていて、複数交換する場合は　,　で区切ってください。
交換せず終了する場合は、'q' を入力してください。
```
  
#### プレイ方法  
初期手札が配られたら、その中から不要なカードを交換します。  
カード交換の際には、カードの番号を指定する必要があります。カード番号は左から 0,1,2,3,4 という順番で割り振られています。  
また、複数のカードを交換する場合は "," で区切って、カード番号を入力してくだい。
例えば、手札が  
```
手札 : ♥2　　♣3　　♦5　　♦J　　♦K　　
役   : なし
```
であり、 ♥2 と ♦5 を交換したい場合には  
`0,2`  
と入力します。すると  
```
手札 : ♣3　　♥4　　♦J　　♦K　　♥K　　
役   : 1ペア
```
というようにカード交換されます。  
  
カード交換しない場合は、 "q"を入力してください。  
  
  
### ブラウザ版ポーカーゲーム(※現在、作成途中ですので実行できません)  
#### URLの取得  
ルートディレクトリ上で  
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
  
 (補足)  
 ・ポーカーゲームのURL取得にはgradleというビルドツールの機能を使っています。今回、gradleをインストールしていただかなくても、URLを取得できたのはPokerプロジェクト内にgradleの機能を使えるようにするファイルがあるためです。gradleに関する詳しい説明は<a href="https://gradle.org/">こちら</a>から。  
 ・tomcatを停止させたい場合は、cmd上で Ctrl + c を入力すると、バッチジョブを終了しますかという内容の質問が表示されるので、yesと答えてください。  
 
   
#### プレイ方法
まず、ブラウザを開き、`http://localhost:8080/Poker/top.jsp` というURLを入力してください。すると、以下のような画面が表示されます。  

![image](https://user-images.githubusercontent.com/51352734/60850771-c0982280-a22b-11e9-8e3e-914fb15d8a25.png)  

  
上の画面が表示されたら、"スタート"ボタンをクリックし、Pokerゲームを開始します。  
ゲーム開始後、以下の画面のように5枚の手札が配られます。役がある場合は、カード下に表示されます。交換したいカードがある場合は、カード番号の横にあるチェックボックスにチェックを入れ、"交換する"ボタンを押してください。交換するカードがない場合は、"このまま勝負する"ボタンを押してください。    
![image](https://user-images.githubusercontent.com/51352734/60850877-1e2c6f00-a22c-11e9-8db2-79bd015d778a.png)  
交換回数は最大で3回までです。交換が終わると結果画面が表示され、"ゲームを終了する"を押すとトップ画面に戻ります。  
![image](https://user-images.githubusercontent.com/51352734/60850942-6186dd80-a22c-11e9-8845-c3fde9afea53.png)    
