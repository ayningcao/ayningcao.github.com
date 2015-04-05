#Markdown语法中文版

* 这边文章翻译自Markdown创始人JOHN GRUBER的 [个人博客](http://daringfireball.net/), 英文原文请参见 [Markdown Syntax](http://daringfireball.net/projects/markdown/syntax "Markdown syntax")
* 个人水平有限, 如有发现错误, 欢迎通过[Github](https://github.com/ayningcao "My Github") 或者 [@乔的果园](http://weibo.com/ayningcao) 联系我修改, 谢谢!
* 如果您不介意, 欢迎关注我的 [微信公众号](#wechat)
* 一些专有名词直译过程中我们约定如下:

	
		Bolck Element: 块元素, 对应HTML中<div>, <p>等;
		Inline Element: 内联元素, 对应HTML中<span>, <i>等
		HTML entity: HTML字符实体, 对应HTML中&lt;等 


[综述(Overview)](#overview)

* [宗旨](#philosophy)
* [内联HTML](#inline-html)
* [特殊字符自动转义](#auto-escape)

[块元素(Block Element)](#block)  

* [段落与换行](#para)
* [头部](#header)
* [引用](#blockquote)
* [列表](#list)
* [代码块](#code-block)
* [水平线](#hr)

[内联元素(Span Element)](#span)  

* [超链接](#link)
* [强调](#em)
* [代码](#code)
* [图片](#image)

[其它](#misc)

* [自动链接](#auto-link)
* [反斜杠转义](#back-slash)


<h2 id="overview">综述</h2>

<h3 id="philosophy">宗旨</h3>

Markdown致力于尽可能地易读易写.

然而, 可读性才是重中之重. 一个Markdown格式的文档应该就像普通文本一样容易(排版)打印, 而不是用各种标签和格式指令来标记. 现有的一些*文本-HTML过滤器(text-to-HTML filters)*对Markdown的语法有着重要的影响, 包括Setext, atx, Textlie, reStructuredText, Grutatext, 和EtText, 然而Markdown语法最大的灵感则来自于纯文本邮件的格式.

鉴于此, Markdown的语法完全由标点字符组成, 这些字符经过精心挑选, 就是为了能够让它们起到它们看起来应该起的作用. 比如一个单词两边的星号看起来就像*emphasis*. Markdown(语法的)列表就应该看起来就像是(实际的)列表. 如果你此前使用的email, 那么即使是Markdown的引用也能够看起来就像是实际的对一段文字的引用一样.

<h3 id="inline-html">内联HTML</h3>
Markdown的语法只有一个目的: 用来作为一种专门为web*写作*设计的格式.

Markdown不是为了取代HTML, 也不是为了接近HTML. 它的语法非常少, 仅对应着HTML标签的一个很小的子集. 创造Markdown的目标*不是*为了让插入HTML标签更容易. 就我个人来说, HTML标签已经很简单了. Markdown的理念是为了让阅读, 编写, 编辑简单文本更加容易. HTML是一个*印刷*格式, 而Markdown是一个*写作*格式. 因此Markdown格式的语法只用于处理能够转变为纯文本的一些功能.

对于那些不包括在Markdown语法之内的标记, 你可以直接使用HTML标签, 而不用在从Markdown语法转换到HTML之前做任何说明或者分隔. 直接使用HTML标签就行了.

唯一的限制是当你使用HTML块元素的时候-例如 `<div>`, `<table>`, `<pre>`, `<p>`等-必须和上下文用空行分开, 并且开始标记和结束标记*不能*使用tab或者空格缩进(否则会被当做代码段). Markdown能够智能地识别出何时不在HTML块级元素添加额外的(不必要)的`<p>`.

例如, 为了向一片Markdown文本添加一个HTML表格:

	This is a regular paragraph.
	
	<table>
	<tr>
	    <td>Foo</td>
	</tr>
	</table>

	This is another regular paragraph.

注意到在HTML块元素标签里面Markdown格式的语法不会被解释, 例如你不能在HTML块元素里面使用Markdown风格的强调\*emphasis\*.

内联HTML元素-例如`<span>`, `<cite>`或者`<del>` -可以在Markdown段落, 列表项或者头部中的任何地方. 你甚至可以使用HTML标签代替Markdown的格式. 例如你可以用HTML的`<a>`或者`<img>`标签代替Markdown的超链接或者图片语法.

与HTML块元素不同的是, 内联元素内的Markdown语法会被解释处理.

<h3 id="auto-escape">特殊字符的自动转义</h3>

在HTML中, 有两个字符需要特殊对待: `<`和`&`. `<`左尖括号表示标签的开始, `&`表示HTML字符实体. 如果你想使用它们的字面常量, 就必须把它们转义成实体, 例如`&lt;` 和`&amp;`.

对于web作家来说字符`&`尤其令人苦恼. 如果你想写一个`'AT&T'`, 你就必须写成` 'AT&amp;T' `.  甚至你需要对URL中的字符`&`进行转义. 因此如果你要链接到:

	http://images.google.com/images?num=30&q=larry+bird

你必须把URL编码成下面这样:

	http://images.google.com/images?num=30&amp;q=larry+bird

然后设置为`<a>`标签`href`属性值. 毋庸置疑这很容易忘记, 并且最容易称为一个编写良好的站点中唯一一个校验错误的地方.

Markdown允许你自然地使用这个字符, 在需要转义的时候替你完成这些任务. 如果你需要在HTML实体里面插入一个 `&`, 那么Markdown不会做任何转换; 否则Markdown会将它转换成 `&amp;`.

所以如果你要包含一个copyright符号在你的文本中, 你可以写成

	&copy;

Markdown将保持它的原样. 但是如果你想写一个:

	AT&T

Markdown就会把它转换成:

	AT&amp;T

类似地, 由于Markdown支持[内联HTML](#inline-html), 如果你用一对尖括号作为HTML标签的分隔符, Markdown则会保持尖括号的原样; 但是如果你要写一个:

	4<5

Markdown就会把它转换成:

	4&lt;5

不管怎样, 在Markdown代码片段和块元素中, 尖括号和符号`&` *始终*会被自动编码. 这就使得使用Markdown编写HTML代码变得很容易. (这和原生HTML代码中糟糕的格式恰好相反, 因为对于每一个代码中的`<`, `>`和`&`你都必须要手动转义).

...

<h2 id="block">块级元素</h2>

<h3 id="para">段落与换行</h3>

一个段落是由一个或多个连续的行组成的, 段与段之间通过一个或多个空行分隔. (除了空格和tab外不包含其他任何字符的行都被视为空行.) 普通的行不能用空格或者tab缩进.

上面"一个或多个连续的行"所暗含的意思就是, Markdown支持"hard-wrapped"文本段落. 这跟大部分把每一个换行符转换成一个HTML`<br />`标签的*text-to-HTML*格式化程序(包括Movable Type's的"转换换行符"选项)有着显著不同.

当你*确实*需要使用Markdown插入一个`<br />`换行标签的时候, 只要在行结尾添加两个或者多个空格再加一个回车就可以了.
  
这的确需要额外的功夫才能插入一个`<br />`, 但是过分简化的"每个换行符就是一个HTML`<br />`标签"的规则不太适用于Markdown. Markdown基于email风格的块引用和列表项最好用-并且更易读-当你用硬换行格式化的时候.  

<h3 id="header">HEADERS头部</h3>

Markdown支持两种风格的头部, [Setext][1]和[atx][2].

Setext风格的头部是使用双等号的下划线(一级头部)和使用破折号的下划线(二级头部). 例如: 

	This is an H1
	=============
	This is an H2
	-------------  

任意数量的`=`和`-`都可以.

Atx风格的头部是在每一行的开头添加1到6个井号字符#, 对应着1级到6级头部. 例如:

	#This is an H1
	##This is an H2
	######This is an H6

你可以选择带有"结束"标记的atx头部. 这纯粹是为了美观-如果你觉得这会让你的Markdown代码更加易读. `#`符号的数目甚至都不用与头部的开始标记数量相同.(开始`#`号的数量用于表示头部的级别):

	#This is an H1 #
	##This is an H2 ##
	###This is an H3 ######  

<h3 id="blockquote">引用</h3>

Markdown使用email风格的字符`>`作为引用. 如果你熟悉email文本里面的引用, 那你就会知道怎样在Markdown里面创建一个引用. 如果你手动排版固定文本并且在每一行开头前面加上一个`>`, 那么看起来是最美观的:

	> This is a blockquote with two paragraphs. Lorem ipsum dolor sit amet,
	> consectetuer adipiscing elit. Aliquam hendrerit mi posuere lectus.
	> Vestibulum enim wisi, viverra nec, fringilla in, laoreet vitae, risus.
	> 
	> Donec sit amet nisl. Aliquam semper ipsum sit amet velit. Suspendisse
	> id sem consectetuer libero luctus adipiscing.  

当然Markdown允许你偷懒, 你只需在一段排版好的文本的第一行添加一个`>`:
	
	> This is a blockquote with two paragraphs. Lorem ipsum dolor sit amet,
	consectetuer adipiscing elit. Aliquam hendrerit mi posuere lectus.
	Vestibulum enim wisi, viverra nec, fringilla in, laoreet vitae, risus.
	
	> Donec sit amet nisl. Aliquam semper ipsum sit amet velit. Suspendisse
	id sem consectetuer libero luctus adipiscing.

引用可以通过添加额外的>实现引用嵌套(例如, 一个引用中的引用):

	> This is the first level of quoting.
	>
	> > This is nested blockquote.
	>
	> Back to the first level.

引用可以包含其他的Markdown元素, 包括头部, 列表和代码块:

	>##This is a header
	>
	>1. This is the first list item
	>2. This is the second list item
	>
	>Here's some example code
	>
	>    return shell_exec("echo $input | $markdown_script");

任何一个不错的文本编辑器都应该能够简化email风格的引用. 例如通过BBEdit你可以选定一段文本然后从文本菜单选择升级引用级别.

<h3 id="list">列表</h3>

Markdown支持有序(编号的)列表和无序列表.
 
无序列表使用星号(`*`), 加号(`+`)和减号(`-`)-可以交替使用-来作为列表标记:  

	* Red
	* Green
	* Blue

等同于:

	+ Red  
	+ Green  
	+ Blue

和

	- Red
	- Green
	- Blue

有序列表使用数字紧跟一个句号.:

	1. Bird
	2. McHale
	3. Parish

重要的一点是, 你用来标记列表项的实际数字并不会影响Markdown所生成的HTML列表格式. 上面使用Markdown生成的HTML列表是:

	<ol>
		<li>Bird</li>
		<li>McHale</li>
		<li>Parish</li>
	</ol>`

如果你像这样编写Markdown:

	1. Bird
	1. Mchale
	1. Parish

甚至这样:

	3. Bird
	1. Mchale
	8. Parish

都能生成完全一样的HTML. 关键在于, 如果你想, 你可以使用有序数字来标记Markdown列表, 这样Markdown源文本里面的数字就能和输出的HTML列表项数字保持一致了. 但是如果你想偷懒, 也可以不强制这样做.

如果你偷懒（不使用有序数字来标记Markdown有序列表), 你仍然应该从1开始标记列表项. 在未来Markdown有可能会支持有序列表的start属性.

一般情况下列表标记从左边开始, 也有可能缩进最多三个空格. 列表标记之后必须紧跟至少一个空格或者一个tab.

为了让列表更加美观, 你可以使用hanging(对齐的)缩进来包装列表项:

	*   Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
	    Aliquam hendrerit mi posuere lectus. Vestibulum enim wisi,
	    viverra nec, fringilla in, laoreet vitae, risus.
	*   Donec sit amet nisl. Aliquam semper ipsum sit amet velit.
	    Suspendisse id sem consectetuer libero luctus adipiscing.

如果你想偷懒, 也可以这样写:
	
	*   Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
	Aliquam hendrerit mi posuere lectus. Vestibulum enim wisi,
	viverra nec, fringilla in, laoreet vitae, risus.
	*   Donec sit amet nisl. Aliquam semper ipsum sit amet velit.
	Suspendisse id sem consectetuer libero luctus adipiscing.

如果你用空行分隔列表项, Markdown输出的HTML代码会将列表项用<p>标签包装起来. 例如:

	* Bird
	* Magic

将被转换成HTML:

	<ul>
		<li>Bird</li>
		<li>Magic</li>
	<ul>


但是下面的:

	* Bird
	
	* Magic

将被转换成:

	<ul>
		<li><p>Bird</p></li>
		<li><p>Magic</p></li>
	</ul>

列表项可能会有多个段落, 每个子段落必须用四个空格或者一个tab缩进:

	1. This is a list item with two paragraphs. Lorem ipsum dolor
	    sit amet, consectetuer adipiscing elit. Aliquam hendrerit
	    mi posuere lectus.
	
	    Vestibulum enim wisi, viverra nec, fringilla in, laoreet
	    vitae, risus. Donec sit amet nisl. Aliquam semper ipsum
	    sit amet velit.
	2. Suspendisse id sem consectetuer libero luctus adipiscing.

对子段落中的每一行使用缩进可以让Markdown文本更加美观. 但是Markdown任然允许你偷懒:

	*   This is a list item with two paragraphs.
	
	    This is the second paragraph in the list item. You're
	only required to indent the first line. Lorem ipsum dolor
	sit amet, consectetuer adipiscing elit.
	
	*   Another item in the same list.

为了在列表项内部插入一个引用, 则需要对引用的>分隔符缩进:

	* A list item with a blockquote:
	    > This is a blockquote
	    > inside a list item

要在列表项里插入代码段, 那么需要对代码段进行两次缩进 - 8个空格或者2个tab:

	* A list item with a code block:
	
	        public class Test() {
				public static void main(String[] args) {
					System.out.println("Hello Markdown");
				}
			}

有时候会不经意间导致生成Markdown列表, 比如这种写法:

	1986. What a great season.

换句话说, 在任一段开头如果如果恰好包含一个 *数字-句号-空格* 序列模式就会生成一个列表项. 你可以在句号前面加一个斜线转义来避免这种情况:

	1986\. What a great season.

<h3 id="code-block">代码块</h3>

格式化的代码块通常用在与编程或者标记文本源码的写作中. 与格式化普通段落不同的是, 我们希望代码块里的行保持原有格式. Markdown将代码块同时用 `<pre>` 和 `<code>` 标签包装起来.

要在Markdown里面生成代码块, 只需要对代码块中的每一行缩进4个空格或者1个tab就可以了. 例如下面这一段文本:

	This is a normal paragraph;
	
	    This is a code block.

Markdown会生成:

    <p>This is a normal paragraph;</p>

    <pre><code>This is a code block    
    </code></pre>

一级缩进-4个空格或1个tab-将会从代码段中被移除. 例如:  
Here is an example of AppleScript:

    tell application "Foo"
        beep
	end tell

将会被转换成:

    <p>Here is an example of AppleScript<\p>

    <pre><code>tell application "Foo"  
        beep
    end tell
    </code></pre>

一个代码段以一个未缩进的行结束(或者文章结尾).

在一个代码段内, `&`, `<`和`>`将被自动转换为HTML实体. 这就使得在Markdown里包含HTML代码段变得非常容易- 粘贴然后缩进, Markdown会自动处理`&`, `<`和`>`的编码. 例如:

    <div class="footer">
        &copy; 2004 Foo Corporation
    </div>

将被转换成:

    <pre><code><pre>&lt;div class="footer"&gt;  
    	&amp;copy; 2004 Foo Corporation
    &lt;/div&gt;
    </code></pre>

代码段内的普通Markdown语法不会被处理, 例如代码段内的星号`*`就是字面量星号`*`. 这就意味着使用Markdown去编写Markdown的语法很容易. 

<h3 id="hr">水平线</h3>

在一行内输入(且只能是)三个或以上的`*`, `-`或`_`就能生成一个水平线(`<hr />`). 当然你可以在连续的`-`或`*`之间插入空格. 下面的每一行都将生成一个水平线:

    * * *

	***

	*****

	- - -

	__________________________________

...

<h2 id="span">内联元素</h2>

<h3 id="link">超链接</h3>

Markdown支持两种风格的链接: 内联式(*inline*)和引用式(*reference*).

这两种风格都要求超链接的文本内容用中括号`[]`分隔.

在中括号的结尾使用一对圆括号`()`就能创建链接地址, 圆括号内部就是要指向的链接地址, 如果你想为链接创建标题那么可以在链接URL之后输入一段用双引号包含的文本. 例如:

    This is [an example](https://ayningcao.github.io "My Github") inline link

	[This link](https://ayningcao.github.io) has no title attribute

将会生成:

	<p>This is <a href="https://ayningcao.github.io" title="My Github">
	an example</a> inline link.</p>

	<p><a href="https://ayningcao.github.io">This link</a> has no
	title attribute.</p>

如果是链接是指向本地资源你也可以使用相对路径:

	See my [About](/about/) apge for details.

引用式的链接是在超链接文本后面添加一对中括号, 中括号的内容是目标URL的标签:

	This is [an example][id] reference-style link.

你也可以在两对中括号之间插入一个空格.

然后你可以在文档其他任何地方定义链接的标签:

	[id]: http://ayningcao.github.io/ "title"

这个引用式链接的格式是:

* 开头是一个中括号`[]`, 中括号里面包含链接ID(从左开始可以包含最多三个空格作为缩进);
* 然后跟着一个冒号`:`;
* 然后是一个或多个空格;
* 链接的实际URL;
* 最后是一个可选的链接标题, 标题用双引号, 单引号或者圆括号包围.

下面这三个链接定义是等价的:

	[Github]: http://github.com/  "github.com"  
	[Github]: http://github.com/  'github.com'
	[Github]: http://github.com/  (github.com)

注意: 在Markdown.pl 1.0.1版本里有一个bug会使得用单引号对title定界出现异常.

也可以用尖括号来包含链接URL：

	[id]: <http://github.com> "Github"

如果URL很长影响可读性, 你也可以把链接title放到下一行, 并用额外的空格或者tab来对齐标题:

	[id]: <https://ayningcao.github.com/index.html>
		"My Own Github"

链接定义只在Markdown处理期间用于创建链接, 并不会输出到最终的HTML.

链接定义可以包含字母, 数字, 空格和标点符号 - 并且大小写不敏感. 比如下面的两个链接定义是等价的:

	[link text][a]
	[link text][A]

在链接的文本本身就是链接名的情况下, 可以通过隐式链接名这种快捷方式省略链接名. 只要用一对空中括号-比如, 通过单词`Google`连接到google.com网站, 你可以直接这样写: 

	[Google][]

然后定义链接:

	[Google]: http://google.com

由于链接名可能会包含空格, 因此你还可以这样写快捷方式:

	Visit [Daring Fireball][] for more information.

然后定义链接:

	[Daring Fireball]: http://daringfireball.net/

链接定义可以被放在Markdown文本中的任何位置. 我个人更加倾向于把他们放在被引用的段落后面. 当然你也可以把他们全部放在文档的末尾, 就像是脚注一样.

这里有一个引用式链接的例子:

	I get 10 times more traffic from [Goole][1] than from [Yahoo][2] or [MSN][3].

	[1]: http://google.com/ "Google"
	[2]: http://search.yahoo.com/ "Yahoo Search"
	[3]: http://search.msn.com/ "MSN Search"

通过隐式链接名快捷方式你可以这样创建:

	I get 10 times more traffic from [Google][] than from
	[Yahoo][] or [MSN][].

	[google]: http://google.com/        "Google"
	[yahoo]:  http://search.yahoo.com/  "Yahoo Search"
	[msn]:    http://search.msn.com/    "MSN Search"

上面两种方式都会生成下面这种HTML代码:

	<p>I get 10 times more traffic from <a href="http://google.com/" title="Google">Google</a> than from <a href="http://search.yahoo.com/" title="Yahoo Search">Yahoo</a> or <a href="http://search.msn.com/" title="MSN Search">MSN</a>.</p>

我们可以对比下使用Markdown内联风格的链接写法:

	I get 10 times more traffic from [Google](http://google.com/ "Google") than from [Yahoo](http://search.yahoo.com/ "Yahoo Search") or [MSN](http://search.msn.com/ "MSN Search").

引用式的链接写法关键点不在于更易写, 而是它会使得你的Markdown原文本明显更加易读. 对比以上两个例子: 使用引用式链接, 段落本身只有81个字符, 而内联方风格要176个字符, 而原始HTML代码则需要234个字符, 而且HTML标签比文本内容竟然都要多.

通过Markdown的引用式链接可以使得源文档格式尽可能与浏览器里渲染出的最终的样式接近. 通过将与文本无关的标记相关的元数据移出段落, 就可以不用打断正常的段落叙述(而将精力集中在文本本身的内容).

<h3 id="em">强调(EMPHASIS)</h3>

Markdown将星号`(*)`和下划线`(_)`作为强调指示符. 被一个`*`或者`_`包围的文本将会被转换成HTML `<em>` 标签的内容, 而被两个`*`或者`_`包围的本文则会被转换成被HTML `<strong>` 标签包围的内容. 例如输入以下Markdown文本:

	*single asterisks*

	_single underscores_

	**double asterisks**

	__double underscores__

会生成

	<em>single asterisks</em>

	<em>single underscores</em>

	<strong>double asterisks</strong>

	<strong>double underscores</strong>


你可以随意选择哪种风格, 唯一的限制就是强调的内容起始和结束标志必须相同.

强调符也可以用在单词中间:

	un*frigging*believable

但是如果你用空格包含一个*或者_, 那么Markdown将会把他们当做普通的星号或者下划线.

在一些情况下星号或者下划线可能被当做强调符号, 这时要生成一个普通的星号或者下划线, 你可以用一个反斜杠来转义

	\*this text is surrounded by literal asterisks\*


<h3 id="code">代码</h3>

可以通过重音符(`` ` ``)来标记一段代码(译者注: 重音符在数字1键左边), 与格式化的代码段不同, 一个代码片段用来标记一个普通段落内的代码. 例如:

	Use the 'printf()' function

将会生成:

	<p>Use the <code>printf()</code> function.</p>

如果要在一个代码行内包含一个字面常量的重音符, 你可以使用多个重音符来作为这一行的起始和开头标记

	``This is a literal backtick (`) here``

将会生成

	<p><code>There is a literal backtick (`) here.</code></p>

一个代码片段定界的重音符可以包含空格, 起始重音符之后和结束重音符之前各包含一个, 这使得你可以在代码片段的开头或者结尾插入字面常量的重音符.

	A single backtick in a code span: `` ` ``

	A backtick-delimited string in a code span: `` `foo` ``

这会生成:

	<p>A single backtick in a code span: <code>`</code></p>

	<p>A backtick-delimited string in a code span: <code>`foo`</code></p>

使用代码片段, `&`, `<`和`>`将会自动被编码成HTML字符实体, 这样就很容易在Markdown段落中包含HTML标签了. Markdown会将下面的文本:

	Please don't use any '<blink>' tags.

转换成:

	<p>Please don't use any <code>&lt;blink&gt;<code> tags</p>

你可以这样写:

	`&#8212;` is the decimal-encoded equivalent of `&mdash;`.

来生成:

	<p><code>&amp;#8212;</code> is the decimal-encoded equivalent of <code>&amp;mdash;</code>.</p>

<h3 id="image">图片(IMAGES)</h3>

设计一种比较"自然"的语法, 能够实现向一段纯文本格式的文档里面插入一张图片, 是相对比较困难的一件事.

Markdown使用一种结合超链接的语法的方式来实现插入图片, 并且支持两种风格: 内联式和引用式.

使用内联式语法的Markdown文本是这样的:

	![Alt text](/path/to/img.jpg)
	
	![Alt text](/path/to/img.jpg "Optional title")

就是:

* 以一个感叹号开头: !;
* 紧跟一对中括号, 中括号的内容是图片的alt属性;
* 然后是一对圆括号, 包含图片的URL和一个可选的图片标题(title)属性, 属性值用单引号或者双引号包围起来.

引用式的图片语法类似下面这样:

	![Alt text][id]

这里的"id" 是一个预定义的图片引用名字. 定义图片引用的语法与引用式链接定义的语法是类似的:

	[id]: url/to/image  "Optional title attribute"

到目前为止, Markdown还没有制定图片尺寸的方法; 如果有必要, 你可以直接使用HTML的`<img>`标签.

...

<h2 id="misc">其它(MISCELLANEOUS)</h2>

<h3 id="auto-link">自动链接</h3>

Markdown为创建指向URL或者EMAIL地址的自动链接提供了一种快捷方式: 用一对尖括号`<>`把URL或者EMAIL地址包围起来就行了. 意思就是说, 如果你想显示URL或者EMAIL地址的值, 并且希望可以直接点击他们(实现跳转), 你就可以直接这样写:

	<http://example.com/>

Markdown会把它转换为:

	<a href="http://example.com/">http://example.com/</a>

指向EMAIL地址的自动链接工作方式大体与链接相同, 不同的是, Markdown会首先对(email地址)执行一些随机十进制和十六进制实体编码, 以防止专门收集email地址的垃圾邮件程序. 例如, Markdown会把下面的地址:

	address@example.com

转换成:
	
	<a href="&#x6D;&#x61;i&#x6C;&#x74;&#x6F;:&#x61;&#x64;&#x64;&#x72;&#x65;&#115;&#115;&#64;&#101;&#120;&#x61;&#109;&#x70;&#x6C;e&#x2E;&#99;&#111;&#109;">&#x61;&#x64;&#x64;&#x72;&#x65;&#115;&#115;&#64;&#101;&#120;&#x61;&#109;&#x70;&#x6C;e&#x2E;&#99;&#111;&#109;</a>

最终在HTML代码中渲染出一个指向 "address@example.com"的链接.

(这种实体编码的方法即时不能糊弄全部的地址爬虫, 也至少可以阻止大部分, 但是肯定不会阻止掉全部的. 这样总比什么都不做要好, 公开你的邮件地址最终会导致你收到垃圾邮件)

<h3 id="back-slash">反斜杠转义字符</h3>

你可以使用Markdown的反斜杠转义字符来生成一些有特殊含义的语法的字面常量. 例如如果你想生成一个星号(`*`, 不是HTML中的`<em>`)包围一个单词, 你就可以在星号之前加上一个反斜杠`\`, 像这样:

	\*literal asterisks\*

Markdown转义字符可以对下面的特殊字符进行转义:

	\   backslash
	`   backtick
	*   asterisk
	_   underscore
	{}  curly braces
	[]  square brackets
	()  parentheses
	#   hash mark
	+   plus sign
	-   minus sign (hyphen)
	.   dot
	!   exclamation mark


<img src="./img/wechat.jpg" alt="my wechat" id="wechat" />