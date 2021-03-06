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

public class LongBindingTest
{

	private final LongBinding binding = new LongBinding();

	@Test
	public void testSerialize() throws Exception
	{
		assertEquals(Long.valueOf(1), binding.deserialize(binding.serialize(1L)));
		assertEquals(Long.valueOf(0), binding.deserialize(binding.serialize(0L)));
		assertEquals(Long.valueOf(100), binding.deserialize(binding.serialize(100L)));

		assertEquals(Long.valueOf(-1), binding.deserialize(binding.serialize(-1L)));
		assertEquals(Long.valueOf(-0), binding.deserialize(binding.serialize(-0L)));
		assertEquals(Long.valueOf(-100), binding.deserialize(binding.serialize(-100L)));
	}

	@Test
	public void testDeserialize() throws Exception
	{
		assertEquals(1, binding.deserialize(binding.serialize(1L)).longValue());
		assertEquals(-2, binding.deserialize(binding.serialize(-2L)).longValue());
		assertEquals(-3, binding.deserialize(binding.serialize(-3L)).longValue());
		assertEquals(Long.MIN_VALUE, binding.deserialize(binding.serialize(Long.MIN_VALUE)).longValue());
		assertEquals(Long.MAX_VALUE, binding.deserialize(binding.serialize(Long.MAX_VALUE)).longValue());
	}

}
