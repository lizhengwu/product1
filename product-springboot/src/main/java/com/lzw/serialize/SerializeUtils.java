package com.lzw.serialize;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

public class SerializeUtils {

	private Entity entity = new Entity();

	/**
	 * 序列化反序列化，对于list的深克隆就使用序列化
	 *
	 * @return
	 * @throws Exception
	 */
	public Object jdkSerialize() throws Exception {


		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(entity);

		byte[] bytes = byteArrayOutputStream.toByteArray();
		//
		// ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		// ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		//
		// Entity readObject = (Entity) objectInputStream.readObject();

		objectOutputStream.close();
		// byteArrayInputStream.close();
		// // 打印数据
		// System.out.println(entity.toString());
		// System.out.println(readObject.toString());
		// // 打印地址
		// System.out.println(Integer.toHexString(entity.hashCode()));
		// System.out.println(Integer.toHexString(readObject.hashCode()));

		return null;

	}

	/**
	 * fastJson 序列化
	 *
	 * @return
	 * @throws Exception
	 */
	public Object fastJsonSerialize() throws Exception {


		String s = JSON.toJSONString(entity);

		Entity readObject = JSON.parseObject(s, Entity.class);

		// // 打印数据
		// System.out.println(entity.toString());
		// System.out.println(readObject.toString());
		// // 打印地址
		// System.out.println(Integer.toHexString(entity.hashCode()));
		// System.out.println(Integer.toHexString(readObject.hashCode()));

		return readObject;
	}





	public Object kryoSerialize() throws Exception {
		Kryo kryo =  new Kryo();

		// Input input = new Input();
		Output output = new Output(1024,1024);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		output.setOutputStream(out);

		kryo.writeObject(output, entity);
		byte[] bytes = output.toBytes();
		// input.setBuffer(bytes);
		//
		// Entity readObject = kryo.readObjectOrNull(input, Entity.class);

		output.close();
		// input.close();
		// // 打印数据
		// System.out.println(entity.toString());
		// System.out.println(readObject.toString());
		// // 打印地址
		// System.out.println(Integer.toHexString(entity.hashCode()));
		// System.out.println(Integer.toHexString(readObject.hashCode()));

		return null;

	}

	static class Entity implements Serializable {
		private final long serialVersionUID = 1L;

		private String id;
		private String name;
		private String age;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Entity{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age='" + age + '\'' + '}';
		}
	}
}
