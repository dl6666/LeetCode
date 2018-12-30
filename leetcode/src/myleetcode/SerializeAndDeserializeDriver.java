package myleetcode;

public class SerializeAndDeserializeDriver {

	public static void main(String[] args) {
		SerializeAndDeserialize sd = new SerializeAndDeserialize();
		TreeNode root = sd.constructTree(new int[] {1,3,4,2,1,5,7,3,1,2});
		sd.print(root);
		String s = sd.serialize(root);
		TreeNode newRoot = sd.deserialize(s);
		sd.print(newRoot);
	}

}
