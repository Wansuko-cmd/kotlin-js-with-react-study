<h1>本レポジトリについて</h1>
本レポジトリはkotlin/js + react.jsの勉強のために立ち上げたものである。

<h1>起動方法</h1>
$yarn start　を実行することで起動することが出来る。

<hr>
<h1>学習内容</h1>

<h2>基本事項</h2>
<p>kotlin/js + react.jsでは、基本的にkotlinで書くことになる。</p>
<p>また、npm（yarn）を使う方法と、Gradleを使う方法とある。</p>
<p>コンポーネントの定義はRComponentを継承することにより行う</p>
<p>また、「RBuilder.コンポーネントの呼び出し名()」も定義する必要がある。
こちらはPropsを使う時にいじる必要が出てくるところである。</p>
<p>定義したコンポーネントは、コンポーネントの呼び出し名()とすれば使用することが出来る。</p>

<h2>・文字の表示について</h2>
<p>文字の表示は、それぞれのコンポーネントのrenderに入れることで反映させることが出来る。</p>
<p>kotlin/js独特の文法として、HTMLタグの中に文字などを入れる場合は先頭に+を入れる必要がある。</p>
<p>例</p>
<p>h1{+"Hello world"}</p>

<h2>・変数、関数について</h2>
<p>変数、関数などもHTMLタグの中に代入することも可能である。
その際にはkotlinの文法である"${}"を使うと良い。</p>
<p>この中は普通にkotlinの文法が使えるので、変数も関数も問題なく入れることが出来る。</p>
<p>なお、そもそも文字列を入れない場合は、ダブルコーテーションで囲まずにそのまま書いてもよい。</p>
<p>例</p>
<p>例えば、引数に整数を渡せば、それの二乗を返り値に持つ関数,square()があるとする。</p>
<p>これの引数にnumを渡して利用する場合には次のように書けばよい</p>
<p>h1{+"${square(num)}"}</p>

<h2>・繰り返し処理について</h2>
<p>特定の表示を繰り返し表示したければHTMLタグとなるところをそのままfor文やwhile文で囲めばよい。</p>
<p>また、その流れでif文でもできると思われるが、もしかしたら避けたほうがいい記述かもしれない。</p>

<h2>・Stateについて</h2>
<p>ReactでもおなじみのStateとは、特定のコンポーネントが、そこで必要な値を
保持するために使うものである。</p>
<p>例えば入力された値であったり、サーバーから受け取った値などである。</p>
<p>kotlin/jsでこれをコンポーネントに適用するためには以下のステップを踏む必要がある</p>
<ol>
<li>Stateに保存する値を定義するためのインターフェイスを、RStateを継承して定義する</li>
<li>使用したいコンポーネントで、RComponentを継承するときに、&lt;RProps, State&gt;の
Stateを、1.のインターフェイス名に変更する</li>
<li>コンポーネント内で、State.init()をオーバーライドして、Stateの値を初期化する</li>
</ol>
<p>また、state内の値を呼び出す際には、「state.呼び出したい変数名」
という形で書くことが必要である</p>

<h2>Propsについて</h2>
<p>あるコンポーネントで得られた値を、特定のコンポーネントに
引数のように渡したいという時にPropsを使う。</p>
<p>Propsで受け取った値はStateに保存することが多いように感じる</p>
<p>kotlin/jsでこれをコンポーネントに適用するためには以下のステップを踏む必要がある</p>
<ol>
<li>Propsで受け取りたい値を定義するためのインターフェイスを、RPropsを継承して定義する</li>
<li>1.で、Propsというインターフェイスを定義したとすると、使用したいコンポーネントで
RComponentを継承するときに、
<p>class コンポーネント名(props: Props)&lt;Props, State&gt;(props)</p>の
ように変更する</li>
<li><p>RBuilder.コンポーネントの呼び出し名(1.で定義した変数を満たす分の引数)
= child(コンポーネント名::class){Propsの部分の初期化
(attrs.hogehoge = hogehogeのように)}</p>
といった感じにRBuilderの拡張関数を変更する</li>
</ol>
<p>また、Stateの初期化の際にPropsの値を利用したい場合は、
Props型のものを引数に持たせることが必要である。</p>
<p>Propsに値を渡す際はコンポーネントを呼び出すときに、hoge(value)といった具合に
引数として記述する必要がある。</p>

<h2>cssについて　その１</h2>
<p>kotlin/jsでは、cssファイルもkotlinで書くことが可能である。</p>
<p>従ってcssも型安全で書けるという意味では有効である。</p>
<p>しかし本来cssとktファイルに分けてゐたものを一つにするため、コードはより丁寧に
書く必要がある。</p>
<p>また、こちらはyarnやnpm等で導入する必要がある。具体的には以下のコマンドを打てばよい</p>
<p>yarn add @jetbrains/kotlin-css @jetbrains/kotlin-css-js @jetbrains/kotlin-styled inline-style-prefixer styled-components@4</p>
<p>これによって書くことが出来るようになる。</p>
<p>実際にkotlinで書くには、本来使っていたHTMLタグ（h1等）にstyledをつける
（styledH1）必要がある。</p>
<p>その後、そのタグの中でcssのくくりを書き、その中で記述していく必要がある</p>
<p>記述例</p>
<p>styledH1{css{backgroundColor = Color.red}}</p>
<p>もちろんここに変数を入れることも可能である。</p>
<p>ちなみに単にcssファイルで書くことも可能である。</p>

<h2>cssについて　その２</h2>
<p>上の書き方であれば、特定のHTMLタグにしかスタイルシートにしか適用できない。</p>
<p>そこで、複数のHTMLタグに適用できるものとして、StyleSheetクラスが存在する。</p>
<p>これをobject型のものに継承させて記述することで、cssのセットのようなものを作ることが出来る。</p>
<p>具体的には、val 変数名 by css{}と記述して、中にはchildren(HTMLタグ){}等と書いて適用させる。</p>
<p>またこれを利用する際には、単に使用したいHTMLタグのcssのところに
`+継承したobjectの名前.変数名`としてやるとよい。</p>

<h2>classNameについて</h2>
<p>通常のHTMLタグであれば<p>`div(classes="hoge"){}`</p>のようにして
クラス名やid名を割り振ることが出来る。
<p>しかし、styledのついたHTMLタグの場合は、そのタグの中のcss{}の中に記述する必要がある。</p>
<p>記述の仕方は、`classes = mutableListOf("hoge", "foo", "bar")`といった感じである。</p>
<p>これによってbootstrap等のcssのフレームワークの導入も簡単にできる。</p>