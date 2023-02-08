/**
 * 
 */
function confirmDialog(mode){
	var text;
	if (mode == 0) {
		text = '登録してよろしいですか？';
	} else if (mode == 1) {
		text = '更新してよろしいですか？';
	} else if (mode == 2) {
		text = '削除してよろしいですか？';
	}
	if(confirm(text)){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	} else { // 「キャンセル」時の処理
		window.alert('キャンセルされました'); // 警告ダイアログを表示
		return false; // 送信を中止
	}
}