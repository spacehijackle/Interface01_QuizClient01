package client.quiz;

import java.util.ArrayList;
import java.util.List;

import com.quiz.Quiz;
import com.quiz.QuizMaster;
import com.quiz.type.ChoiceItem;
import com.quiz.type.FreeAnswerQuiz;
import com.quiz.type.SingleChoiceQuiz;

import client.quiz.type.YesNo;
import client.quiz.type.YesNoQuiz;

/**
 * たかしカルトＱ
 * <p>
 * 細川たかしに特化したクイズ
 * </p>
 *
 * @author t.yoshida
 */
public class TakashiCultQ implements QuizMaster
{
	// クイズリスト
	private List<Quiz> _listQuiz;

	/**
	 * たかしカルトＱを生成する。
	 */
	public TakashiCultQ()
	{
		_listQuiz = new ArrayList<>();

		// クイズの作成
		buildQuizList();

		// クイズのシャッフル
		//Collections.shuffle(_listQuiz);
	}

	@Override
	public String getTitle()
	{
		String retCode = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder(100);
		sb.append("💎 細川たかしマニアクイズ！").append(retCode);
		sb.append("").append(retCode);
		sb.append("  ～～♪～～♪～～♪～～ 🎤 たかしカルトＱ 💰 ～～♪～～♪～～♪～～").append(retCode);
		sb.append("").append(retCode);

		return sb.toString();
	}

	@Override
	public Quiz poll()
	{
		if(_listQuiz.size() == 0) return null;

		Quiz quiz = _listQuiz.remove(0);
		return quiz;
	}

	/**
	 * クイズを作成する。
	 */
	private void buildQuizList()
	{
		_listQuiz.add
		(
			new FreeAnswerQuiz("近藤真彦はマッチ。ではたかしは？", "タッチ")
		);
		_listQuiz.add
		(
			new YesNoQuiz
			(
				"たかしの髪型に違和感があるのは散髪に失敗したせいである？", YesNo.Yes
			)
		);
		_listQuiz.add
		(
			new SingleChoiceQuiz
			(
				"たかしの弟子を一人選べ",
				new ChoiceItem("やなせたかし", false),
				new ChoiceItem("こぶしたかし", true),
				new ChoiceItem("そりまちたかし", false)
			)
			{
				@Override
				public String getAnswer()
				{
					return super.getAnswer() + "（＝レイザーラモンＲＧ）";
				}
			}
		);
		_listQuiz.add
		(
			new SingleChoiceQuiz
			(
				"たかしと同じ仲間を一人選べ",
				new ChoiceItem("バイキング小峠", false),
				new ChoiceItem("クロちゃん", false),
				new ChoiceItem("キダ・タロー", true),
				new ChoiceItem("ブルース・ウィリス", false)
			)
		);
	}
}
