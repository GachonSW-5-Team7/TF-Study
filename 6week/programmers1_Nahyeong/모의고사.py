def solution(answers):

    student=[[1,2,3,4,5],[2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]]
    score1=[]
    score2=[]
    score3=[]   

    answer=[]

    for i in range(len(answers)):
        if answers[i]==student[0][i%5]:
            score1.append(answers[i])

        if answers[i]==student[1][i%8]:
            score2.append(answers[i])

        if answers[i]==student[2][i%10]:
            score3.append(answers[i])

    result=[len(score1),len(score2),len(score3)]
    best=max(result)

    res_list=list(filter(lambda x: result[x]==best,range(len(result))))

    if len(res_list)==1:
        if(res_list[0]==0):
            answer.append(1)
        elif(res_list[0]==1):
            answer.append(2)
        elif(res_list[0]==2):
            answer.append(3)
    else:
        answer=res_list
        answer.sort()

        for i in range(len(answer)):
            answer[i]+=1  

    return answer