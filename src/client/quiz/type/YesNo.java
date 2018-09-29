package client.quiz.type;

/**
 * Yes/No を表す列挙型
 *
 * @author t.yoshida
 */
public enum YesNo
{
	Yes("Yes", "Yah", "Y"),
	No("No", "N");

	// Yes/No を判断する上で許容可能な文字列の配列
	private String[] _acceptables;

	/**
	 * Yes/No を表す列挙型を生成する。
	 *
	 * @param acceptables Yes/No を判断する上で許容可能な文字列
	 */
	private YesNo(String... acceptables)
	{
		_acceptables = acceptables;
	}

	/**
	 * 指定された回答から Yes/No を判定する。
	 * <p>
	 * 指定された回答と Yes/No を判断する上で許容可能な文字列を比較し（大小文字無視）、
	 * 一致した場合に true を返す。
	 * </p>
	 * <pre>
	 * YesNo.Yes.judge("YES") → true
	 * YesNo.Yes.judge("Y")   → true
	 * YesNo.Yes.judge("OK")  → false
	 * </pre>
	 *
	 * @param reply 回答
	 * @return true: Yes/No と判定された場合
	 */
	public boolean judge(String reply)
	{
		for(String acceptable : _acceptables)
		{
			if(acceptable.equalsIgnoreCase(reply))
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString()
	{
		return _acceptables[0];
	}
}
