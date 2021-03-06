package org.rapidpm.workshop.frp.m05_functional.v002_memoizing;

import org.rapidpm.workshop.frp.core.model.Memoizer;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Copyright (C) 2010 RapidPM
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by RapidPM - Team on 10.12.16.
 */
public class M05V003 {

  private static final BiFunction<Integer,Integer,Integer> biFunction = (x, y) -> x * y;
  private static final Function<Integer, Function<Integer, Integer>> function = x -> y -> x * y;

  public static final Function<Integer, Function<Integer,Integer>> memoizationFunction
      = Memoizer.memoize(x -> Memoizer.memoize(y -> x * y));

  public static void main(String[] args) {
    System.out.println("memoizationFunction = " + memoizationFunction.apply(2).apply(3));
    System.out.println("memoizationFunction = " + memoizationFunction.apply(2).apply(3));
  }
}
