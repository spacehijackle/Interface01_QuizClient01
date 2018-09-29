package client.quiz.type;

import com.quiz.Quiz;

/**
 * Yes/No 回答方式クイズ
 *
 * @author t.yoshida
 */
public class YesNoQuiz implements Quiz
{
	// 問題文
	private String _question;

	// Yes/No
	private YesNo _yesNo;

	/**
	 * Yes/No 回答方式クイズを生成する。
	 *
	 * @param question 問題文
	 * @param yesNo Yes/No
	 */
	public YesNoQuiz(String question, YesNo yesNo)
	{
		_question = question;
		_yesNo = yesNo;
	}

	@Override
	public String getQuestion()
	{
		return _question + " ※Yes/Noで回答";
	}

	@Override
	public boolean isCorrect(String reply)
	{
		return (_yesNo.judge(reply));
	}

	@Override
	public String getAnswer()
	{
		return _yesNo.toString();
	}
}
