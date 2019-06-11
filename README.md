# Poker

ポーカーゲーム  

<概要>  
まず、初めに5枚のカードが配られます。その後、交換したいカードを選び交換していきます。交換回数は3回です。  
手札の下に表示されているのは、役となります。

<ファイルのダウンロードと>  
まず、このゲームを行うために、Poker.jarをダウンロードしてください。そして、cmdを開き、Poker.jarがあるディレクトリまで進み、実行してください。  
実行方法は、  
　　　　　chcp  65001   
         java -Dfile.encoding=UTF-8  Poker.jar  
と入力していただくと、ゲームが始まります。  

<操作説明>  
1.　Poker.jarファイルを実行していただくと, startの記入を求められるので start を記入します。  
2.　5枚のカードが配られるので、その中に不要なカードがあればそのカード番号を記入してください。カード番号は左
　　から0,1,2,3,4と割り振られております。  
  　※ 複数交換したい場合は、 "," で区切って入力してください。  
   　　(ex)　♥3　♠5　♠8　☘9　♠12　　　　♠5と♠8が不要　→　1,2 と記入  
3.　カード交換を3回行います。  

<実行の注意点>  
 実行する際は、コンソールとソースコードの文字コードを一致させてください。  
 (ex) cmd の場合  
 　　　chcp  65001 (cmdの文字コードをUTF-8にする)  
         java -Dfile.encoding=UTF-8  Poker.jar   (ソースコード側のエンコード、ファイル実行)  
