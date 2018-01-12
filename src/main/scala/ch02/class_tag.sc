import scala.reflect.runtime.universe._
import scala.reflect.{ClassTag, classTag}

val tt = typeTag[Int]
tt.tpe

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
