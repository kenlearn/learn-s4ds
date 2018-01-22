import scala.reflect.runtime.universe._
import scala.reflect.{ClassTag, classTag}

val tt = typeTag[Int]
tt.tpe

// explain TypeTag ClassTag WeakTypeTag:
// https://medium.com/@sinisalouc/overcoming-type-erasure-in-scala-8f2422070d20

// example from https://docs.scala-lang.org/overviews/reflection/typetags-manifests.html

def paramInfo[T](x: T)(implicit tag: TypeTag[T]): Unit = {
    val targs = tag.tpe match {
        case TypeRef(x,y,args) => {
            println(s"$x, ${x.getClass.getName}")
            println(s"$y, ${y.getClass.getName}")
            println(s"$args, ${args.getClass.getName}")
            args
        }
    }
    println(s"type of $x has type args $targs")
}

paramInfo(List(1,2))

// simpler version of paramInfo
def paramInfo2[T: TypeTag](x: T): Unit = {
    val targs = typeOf[T] match {
        case TypeRef(_,_,args) => args
    }
    println(s"type of $x has type args $targs")
}

paramInfo2(List(3,4))

// exmple from http://www.scala-lang.org/api/2.12.4/scala/reflect/ClassTag.html
def mkArray[T: ClassTag](elems: T*) = Array[T](elems: _*)
// equivalent to: 
// mkArray[T](elems: T*)(implicit ev: ClassTag[T])


// example from:
// https://medium.com/@sinisalouc/overcoming-type-erasure-in-scala-8f2422070d20

def extract[T](list: List[Any])(implicit tag: ClassTag[T]) =
// def extract[T: ClassTag](list: List[Any]) = // simpler, context bound
  list.flatMap {
    case element: T => Some(element)
    case _ => None
  }

val list: List[Any] = List(1, "string1", List(), "string2")
val result = extract[String](list)
println(result)

def recognize[T](x: T)(implicit tag: TypeTag[T]): String = {
  tag.tpe match {
    case TypeRef(utype, usymbol, args) =>
      List(utype, usymbol, args).mkString("\n")
  }
}

val list: List[Int] = List(1,2)
val result = recognize(list)

println(result)
