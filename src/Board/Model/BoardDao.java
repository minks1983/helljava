package Board.Model;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    
    private static BoardDao boardDao = null;
    private static List<BoardDto> boardDtoList = new ArrayList<BoardDto>();
    public static int BOARD_MAX_NUM = 1;

    private BoardDao() {
    }
    
    public static BoardDao getInstance() {
        if(boardDao == null)
            boardDao = new BoardDao();
        
        return boardDao;
    }
    
    public int getMaxBoardNum() {
        for(BoardDto currentBoard : boardDtoList) {
            if(BOARD_MAX_NUM < currentBoard.getBoard_num())
                BOARD_MAX_NUM = currentBoard.getBoard_num();
        }
        
        return BOARD_MAX_NUM;
    }

    // 글의 개수를 구하는 함수
    // List.jsp
    public int getListCount() {
        return boardDtoList.size();
    }

    // 글의 리스트 구성
    // List.jsp
    public List getBoardList() {
        return boardDtoList;
    }

    // 글 내용 보기.
    // view.jsp
    public BoardDto getDetail(int num) throws Exception {
        for(BoardDto currentBoard : boardDtoList) {
            if(num == currentBoard.getBoard_num())
                return currentBoard;
        }
        
        return null;
    }

    // 글 등록
    // write.jsp
    public boolean boardInsert(BoardDto board) {
        boardDtoList.add(board);
        return true;
    }

    // 글 수정
    // modify.jsp
    public boolean boardModify(BoardDto modifyboard) throws Exception {
        for(BoardDto currentBoard : boardDtoList) {
            if(modifyboard.getBoard_num() == currentBoard.getBoard_num()) {
                currentBoard.setBoard_subject(modifyboard.getBoard_subject());
                currentBoard.setBoard_content(modifyboard.getBoard_content());
                return true;
            }
        }
        
        return false;
    }

    // 글 삭제
    // delete.jsp
    public boolean boardDelete(int num) {
        for(BoardDto currentBoard : boardDtoList) {
            if(num == currentBoard.getBoard_num())
                return boardDtoList.remove(currentBoard);
        }
        
        return false;
    }

}
