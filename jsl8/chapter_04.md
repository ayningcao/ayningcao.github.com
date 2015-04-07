#类型, 值和变量
Java是一种*静态类型语言*, 这就是说, 在编译期间每一个变量和表达式的类型都是已知的.

Java也是一种*强类型语言*, 因为类型限定了一个变量可被赋予的值, 或者是一个表达式所生成的值, 也限定了可以作用于值得操作符类型, 并且也决定了作用在操作符的含义. 强静态类型能够在编译期发现错误.

Java的数据类型被分为两类: 原始类型(primitive types)和引用类型(reference types). 原始类型包括`boolean`和数值类型. 数值类型包含整型的`byte`, `short`, `int`, `long`和`char`, 以及浮点类型的`float`和`double`. 引用类型包含class类型, 接口(interface)类型和数组类型, 还包括一种特殊的`null`类型. 对象就是一个动态创建的class类型的实例或者是一个动态创建的数组. 引用类型的值就是到一个对象的引用. 所有的对象, 包括数组都支持`Object`类的方法. String的字面常量通过`String`对象来表示.

<h3 id="m4.1">4.1 类型与值的种类</h3>

Java语言中有两种类型: 原始类型(primitive types)和引用类型(reference types), 对应着那些可以赋值给变量, 或被当做参数传递, 或被当做返回值和操作数的两种类型的数据: 原始数据和引用数据.

		Type:
			Primitive Type
			Reference Type
			
还有一种特殊的无名类型null, , 这是表达式`null`的所属的类型.

由于null类型没有名字, 所以无法声明一个null类型的变量, 或者强制转型到null.

null类型唯一可能的值就是null引用.

null类型可以任意赋值或者强制转型到引用类型.

<h3 id="m4.2">4.2 原始类型和数据</h3>

原始类型是Java中预定义的, 并且用保留关键词来命名:

	PrimitiveType:
		{Annotation} NumericType
		{Annotation} boolean
		
	NumericType:
		IntegralType
		FloatingPointType
		
	IntegralType:
		(one of)
		byte short int long char
		
	FloatingPointType:
		(one of)
		float double

原始值不与其他原始值共享状态.

