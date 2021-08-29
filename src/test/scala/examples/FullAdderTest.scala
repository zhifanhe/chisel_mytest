// See LICENSE.txt for license details.
package examples
/*
import org.scalatest._
import chisel3._
import chisel3.experimental.BundleLiterals._
import chiseltest._
import java.util.Random

class FullAdderTest extends FlatSpec with ChiselScalatestTester with Matchers{
    behavior of "mytest2"
    it should "do something" in{
        test(new FullAdder() ){ c =>
            val randNum = new Random
            val a    = randNum.nextInt(2)
            val b    = randNum.nextInt(2)
            val cin  = randNum.nextInt(2)
            val res  = a + b + cin
            val sum  = res & 1
            val cout = (res >> 1) & 1
            c.io.a.poke(a.U)
            c.io.b.poke(b.U)
            c.io.cin.poke(cin.U)
            c.clock.step(1)
            c.io.sum.expect(sum.U)
            c.io.cout.expect(cout.U)
        }
    }
}
*/


import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}

class FullAdderTests(c: FullAdder) extends PeekPokeTester(c) {
  for (t <- 0 until 4) {
    val a    = rnd.nextInt(2)
    val b    = rnd.nextInt(2)
    val cin  = rnd.nextInt(2)
    val res  = a + b + cin
    val sum  = res & 1
    val cout = (res >> 1) & 1
    poke(c.io.a, a)
    poke(c.io.b, b)
    poke(c.io.cin, cin)
    step(1)
    expect(c.io.sum, sum)
    expect(c.io.cout, cout)
  }
}


object  FullAdderTestGen extends App{
    chisel3.iotesters.Driver.execute(args,()=>new FullAdder())(c => new FullAdderTests(c))
}

