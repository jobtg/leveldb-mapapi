// Copyright 2013 GridLine
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package nl.gridline.leveldb.bindings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test the {@link IntegerBinding} class
 * @author <a href="mailto:job@gridline.nl">Job</a>
 */
public class IntegerBindingTest
{

	private final IntegerBinding binding = new IntegerBinding();

	@Test
	public void testSerialize() throws Exception
	{
		assertEquals(Integer.valueOf(1), binding.deserialize(binding.serialize(1)));
		assertEquals(Integer.valueOf(0), binding.deserialize(binding.serialize(0)));
		assertEquals(Integer.valueOf(100), binding.deserialize(binding.serialize(100)));

		assertEquals(Integer.valueOf(-1), binding.deserialize(binding.serialize(-1)));
		assertEquals(Integer.valueOf(-0), binding.deserialize(binding.serialize(-0)));
		assertEquals(Integer.valueOf(-100), binding.deserialize(binding.serialize(-100)));
	}

	@Test
	public void testDeserialize() throws Exception
	{
		assertEquals(1, binding.deserialize(binding.serialize(1)).intValue());
		assertEquals(-2, binding.deserialize(binding.serialize(-2)).intValue());
		assertEquals(-3, binding.deserialize(binding.serialize(-3)).intValue());
		assertEquals(Integer.MIN_VALUE, binding.deserialize(binding.serialize(Integer.MIN_VALUE)).intValue());
		assertEquals(Integer.MAX_VALUE, binding.deserialize(binding.serialize(Integer.MAX_VALUE)).intValue());

	}
}
