#Markdown语法
###综述
*    思想
*    内联HTML
*    特殊字符自动转义

###块元素(Block Element)
*    段落
*    标题
*    引用
*    列表
*    代码块
*    水平线

###行元素(Span Element)
*    超链接
*    强调
*    代码
*    图片

##综述
###思想
Markdown致力于尽可能地易读易写.

然而可读性才是重中之重. 一个Markdown格式的文档应该就像普通文本一样容易印刷出来, 而不是用各种标签和格式指令来标记. 现有的一些文本到HTML过滤器(existing text-to-HTML filters)对Markdown的语法有着重要的影响, 包括Setext, atx, Textlie, reStructuredText, Grutatext, 和EtText, 然而Markdown语法最大的灵感则来自于纯文本邮件的格式.

鉴于此, Markdown的语法全部由标点字符组成, 这些字符经过精心挑选, 就是为了能够让它们起到它们看起来应该起的作用. 比如一个字符两边的星号看起来就像*emphasis*. Markdown(语法的)列表看起来就像是(实际的)列表. 如果你此前使用的email, 那么即使是Markdown的引用也能够看起来就像是实际的对一段文字的引用一样.

###内联HTML
Markdown的语法只有一个目的: 用来作为一种编写web文本的格式.

Markdown不是为了取代HTML, 也不是为了接近HTML. 它的语法非常简单, 仅对应着一个很小的HTML标签子集. 创造Markdown的目标不是为了让插入HTML标签更容易. 就我个人来说, HTML标签已经很简单了. Markdown的理念是为了让阅读, 编写, 编辑简单文本更加容易. HTML是一个印刷格式, 而Markdown是一个用于编写的格式. 因此Markdown格式的语法只用于处理能够转变为纯文本的一些功能.

对于那些不包括在Markdown语法之内的标记, 你可以直接使用HTML标签, 而不用在从Markdown语法转换到HTML之前做任何说明或者分隔. 直接使用HTML标签就行了.

唯一的限制是当你使用HTML块级元素的时候-例如 <div>, <table>, <pre>, <p> 等- 必须和上下文用空行分开, 并且开始标记和结束标记不能使用tab或者空格缩进. Markdown能够识别出何时不在HTML块级元素添加额外的(不必要)的<p>.

例如, 为了向一片Markdown文本添加一个HTML表格:

This is a regular paragraph.

<table>
    <tr>
        <td>Foo</td>
    </tr>
</table>

This is another regular paragraph.

注意到在HTML块级元素标签里面Markdown格式的语法不会被解释, 例如你不能在HTML块元素里面使用Markdown风格的*emphasis*.

行级HTML元素-例如<span>, <cite>或者<del> -可以在Markdown段落的任何段落, 列表或者头部中. 你甚至可以使用HTML标签代替Markdown的格式. 例如你可以用HTML的<a>或者<img>标签代替Markdown的超链接或者图像语法.

与HTML块元素不同的是, 行内元素内的Markdown语法会被解释处理.

###特殊字符的自动转义

在HTML中, 有两个字符需要特殊处理: <和&. <号表示标签的开始, &表示HTML字符实体. 如果你想把他们当做字符常量使用, 就必须把他们转义成实体, 例如&lt; 和&amp;

对于web开发人员来说字符&尤其令人苦恼. 如果你想写一个'AT&T', 你就必须写成'AT&amp;T'.  甚至你需要对URL中的字符&进行转义. 因此如果你要链接到

http://images.google.com/images?num=30&q=larry+bird

你必须把URL编码成下面这样:

http://images.google.com/images?num=30&amp;q=larry+bird

设置为<a>标签href属性值. 毋庸置疑这很容易忘记, 并且最容易称为一个编写良好的站点中唯一一个校验错误的地方.

所以如果你要包含一个copyright符号在你的文本中, 你可以写成

&copy;

Markdown将保持它的原样. 但是如果你想写一个:

AT&T

Markdown就会把它转换成:

AT&amp;T

类似地由于Markdown支持内联HTML, 如果你写了一个尖括号作为HTML标签的分隔符, Markdown则会保持尖括号的原样; 但是如果你要写一个:

4<5

Markdown就会把它转换成:

4&lt;5

不管怎样, inside Markdown code spans and blocks, 尖括号和符号&始终会被自动编码. 这就使得使用Markdown编写HTML代码变得很容易. (这和原生HTML代码中糟糕的格式恰好相反, 因为对于每一个尖括号和符号&你都必须要转义)


...

##块级元素
###段落与换行
一个段落是由一个或多个连续的行组成的, 这些行被一个或多个空行分隔. (除了空格和tab不包含其他任何字符的行A blank line is any line that looks like a blank line — a line containing nothing but spaces or tabs is considered blank.)一个普通的行不应用空格或者tab缩进.

上面"一个或多个连续的行"所暗含的意思就是, Markdown支持"hard-wrapped"文本段落. 这跟大部分把每一个换行符转换成一盒HTML<br />标签的text-to-HTML格式化格式化程序有着显著不同.

当你确实需要使用Markdown插入一个<br />换行标签的时候, 只要在行结尾添加两个或者多个空格再加一个回车就可以了.  
这的确需要额外的功夫才能插入一个<br />, 但是过分简化的"每个换行符就是一个HTML<br />标签"的规则不太适用于Markdown. Markdown基于email风格的块引用和列表项最好用-并且更易读-当你用硬换行格式化的时候.  

###HEADERS头部
Markdown支持两种风格的头部, Setext和atx.  
Setext风格的头部是使用双等号的下划线(一级头部)和使用破折号的下划线(二级头部). 例如:  
This is an H1
=============
This is an H2
-------------  

任意数量的=和-都可以.  
Atx风格的头部是在每一行的开头添加1到6个井号字符#, 对应着1级到6级头部. 例如:  
#This is an H1
##This is an H2
######This is an H6  
你可以选择带有"结束"风格的atx头部. 这纯粹是为了美观-如果你觉得这会让你的Markdown代码更加易读你可以这样用. "结束"#符号的数目甚至都不用与头部的开始标记数量相同.(开始#号的数量用于表示头部的级别):  
#This is an H1 #
##This is an H2 ##
###This is an H3 ######  

###引用
Markdown使用email风格的字符 > 作为引用. 如果你熟悉email文本里面的引用, 那你就会在Markdown里面创建一个引用. 如果你包含一段文本并且在每一行前面添加一个 >:
> This is a blockquote with two paragraphs. Lorem ipsum dolor sit amet,
> consectetuer adipiscing elit. Aliquam hendrerit mi posuere lectus.
> Vestibulum enim wisi, viverra nec, fringilla in, laoreet vitae, risus.
> 
> Donec sit amet nisl. Aliquam semper ipsum sit amet velit. Suspendisse
> id sem consectetuer libero luctus adipiscing.  

当然Markdown允许你偷懒, 你只需在一段hard-wrapped的文本的第一行添加一个>:
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
>1.    This is the first list item
>2.    This is the second list item
>
>Here's some example code
>
>      return shell_exec("echo $input | $markdown_script");

任何一个不错的文本编辑器都应该能够简化email风格的引用. 列入通过BBEdit你可以选定一段文本然后从文本菜单选择升级引用级别.

###列表
Markdown支持有序(编号的)列表和无序列表.  
无序列表使用星号(*), 加号(+)和减号(-)-可以交替使用-来作为列表标记:  

*    Red
*    Green
*    Blue

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

重要的一点是, 你用来标记列表项的实际数字并不会影响Markdown所生成的HTML格式. 上面使用Markdown生成的HTML列表是:
<ol>
<li>Bird</li>
<li>McHale</li>
<li>Parish</li>
</ol>

如果你像这样编写Markdown:

1. Bird
1. Mchale
1. Parish

甚至这样:

3. Bird
1. Mchale
8. Parish

都能生成完全一样的HTML. 重点在于, 如果你想你可以使用有序的数字来标记Markdown列表, 这样Markdown源文件里面的数字就能和输出的HTML列表项数字保持一致了. 但是如果你想偷懒, 你也可以不必须这样做.

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

如果你用空行分隔列表强, Markdown输出的HTML代码会将列表项用<p>标签包装起来. 例如:

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

* Alist item with a code block:

        public class Test() {
			public static void main(String[] args) {
				System.out.println("Hello Markdown");
			}
		}

