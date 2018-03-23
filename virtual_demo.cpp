class Box 
{

public:
	double length;
	double breadth;
	double height;
	double getVolume();
	friend void printWidth(Box box);
	//= 0 告诉编译器，函数没有主体，该虚函数是纯虚函数。
	virtual int area() = 0;
	virtual double getLength() = 0;

public:
	static int id;

};

//静态成员变量在类中仅仅是声明，没有定义，所以要在类的外面定义，
//实际上是给静态成员变量分配内存。如果不加定义就会报错，初始化是赋一个初始值，而定义是分配内存。
int Box::id = 10;


//在类的外部定义
double Box::getVolume()
{
	return this->length * this->breadth * this->height;
}

void printWidth(Box box) {
	cout << "Width of box is :" << box.width << endl;
}

class SubBox : public Box
{

public:
	SubBox();
	SubBox(double wid);
	~SubBox();
};

SubBox::SubBox()
{
	cout << "The construction function of SubBox is called." << endl;
}

SubBox::~SubBox()
{
	cout << "The delete function of SubBox is called." << endl;
}

const int count = 10; //int const count = 10;
const Box box; // Box const box;

char* const cp1; //到char的const指针
char const *cp2; //到const char的指针
const char* cp3; //到const char的指针（后两个声明是等同的）

void fun(const A* in);//修饰指针型传入参数
void fun2(const A& in);//修饰引用型传入参数

//const只对它左边的东西起作用，唯一的例外就是const本身就是最左边的修饰符，
//那么它才会对右边的东西起作用。根据这个规则来判断，
//m1应该是常量指针（即，不能通过m1来修改它所指向的内容。）；
//而m2应该是指针常量（即，不能让m2指向其他的内存模块）。
const int *m1 = new int(10); //常量指针

int* const m2 = new int(20); //指针常量

int const a = 10;
const int a = 10;
const int* p = &a;
int* const p = &a;
const int* const p = &a;
void fun() const;
const int fun();

int main()
{
	Box box1;

	Box* ptrBox = &box1;
	Box* ptrBox2 = new Box1;



	return 0;
}